package ru.meseen.dev.compost.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author Vyacheslav Doroshenko
 */
class MainViewModel(val stateHandle: SavedStateHandle) : ViewModel() {

    private val _lincData = MutableLiveData("Говно все это")
     val lincData: LiveData<String> = _lincData

     var linc: String = ""
        set(value) {
            _lincData.postValue(value)
            field = value
        }
}