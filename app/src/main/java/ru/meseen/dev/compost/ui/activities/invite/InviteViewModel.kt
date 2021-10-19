package ru.meseen.dev.compost.ui.activities.invite

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import ru.meseen.dev.compost.ui.activities.base.BaseViewModel

/**
 * @author Vyacheslav Doroshenko
 */
class InviteViewModel (private val stateHandle: SavedStateHandle) : BaseViewModel<Uri>() {

    override val liveData: LiveData<Uri> = MutableLiveData()

    fun generateContentLink() {
        val baseUrl = Uri.parse("https://dev.meseen.ru/?page_id=574")
        val domain = "https://learncompost.page.link"

        FirebaseDynamicLinks.getInstance().createDynamicLink().apply {
            link = baseUrl
            domainUriPrefix = domain
            //setAndroidParameters(DynamicLink.AndroidParameters.Builder("ru.meseen.dev.compost").build()) Если есть на GP
        }.buildDynamicLink().also { link->
            liveData.postValue(link.uri)
        }
    }
}