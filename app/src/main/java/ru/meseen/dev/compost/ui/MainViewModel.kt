package ru.meseen.dev.compost.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author Vyacheslav Doroshenko
 */
class MainViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        const val SOME_KEY = "SOME_KEY"
    }

    init {
        if (!stateHandle.contains(SOME_KEY)) {
            stateHandle.set(SOME_KEY, "Говно все это")
        }
    }

    val lincData: LiveData<String> = stateHandle.getLiveData(SOME_KEY)

    var linc: String = ""
        set(value) {
            stateHandle.set(SOME_KEY, value)
            field = value
        }

}