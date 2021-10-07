package ru.meseen.dev.compost.ui.activities.base

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * @author Vyacheslav Doroshenko
 */
abstract class BaseViewModel : ViewModel() {

    abstract val lincInvite : LiveData<Uri>

}