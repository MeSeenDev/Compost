package ru.meseen.dev.compost.ui.activities.deep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.URLUtil
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import ru.meseen.dev.compost.R
import ru.meseen.dev.compost.ui.theme.CompostTheme
import ru.meseen.dev.compost.ui.theme.greyDark
import ru.meseen.dev.compost.ui.views.AppBar
import ru.meseen.dev.compost.ui.views.IconaView

/**
 * @author Vyacheslav Doroshenko
 */
class DeepActivity : ComponentActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewModel by viewModels<DeepViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
        grepDeepLinc()
    }

    @Composable
    private fun MainScreen() {
        val text: String by viewModel.lincData.observeAsState("Говно все это")
        CompostTheme() {
            Surface(color = greyDark) {
                IconaView
                    .icona(text = text, drawableId = R.drawable.cat) {
                        if (viewModel.linc.isNotBlank() && URLUtil.isValidUrl(viewModel.linc)) {
                            val openUrl = Intent(Intent.ACTION_VIEW)
                            openUrl.data = Uri.parse(viewModel.linc)
                            startActivity(openUrl)
                        } else {
                            Toast.makeText(this, "Компост говна Пирога", Toast.LENGTH_SHORT).show()
                        }
                    }
                AppBar.mainAppBar(text = "Compost")
            }
        }
    }


    private fun grepDeepLinc() {
        kotlin.runCatching {
            intent?.let { lincIntent ->
                Firebase.dynamicLinks.getDynamicLink(lincIntent).apply {
                    addOnSuccessListener(this@DeepActivity) { pendingDynamicLinkData ->
                        pendingDynamicLinkData?.link?.let { uri ->
                            viewModel.linc = uri.toString()
                        }
                        addOnFailureListener(this@DeepActivity) { e ->
                            Log.wtf(TAG, "getDynamicLink:onFailure", e)
                        }
                    }
                }
            }
        }

    }
}

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CompostTheme() {
            Surface(color = greyDark) {
                IconaView
                    .icona(text = "ass", drawableId = R.drawable.cat)
                AppBar.mainAppBar(text = "Compost")
            }
        }

    }
