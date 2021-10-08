package ru.meseen.dev.compost.ui.activities.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Vyacheslav Doroshenko
 */
abstract class BaseViewModel<Type> : ViewModel() {

    abstract val liveData : LiveData<Type>

    protected fun <T> LiveData<T>.postValue(value : T){
        (this as MutableLiveData).postValue(value)
    }

}