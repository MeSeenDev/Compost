package ru.meseen.dev.compost.ui.activities.invite

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.meseen.dev.compost.R
import ru.meseen.dev.compost.ui.theme.CompostTheme
import ru.meseen.dev.compost.ui.theme.greyDark
import ru.meseen.dev.compost.ui.views.AppBar
import ru.meseen.dev.compost.ui.views.IconaView

/**
 * @author Vyacheslav Doroshenko
 */
class InviteActivity : ComponentActivity() {


    private val viewModel by viewModels<InviteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InviteView()
        }
        viewModel.lincInvite.observe(this) { link ->
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, link.toString())
            startActivity(Intent.createChooser(intent, "share Invite"))
        }
    }


    @Composable
    fun InviteView() {
        CompostTheme() {
            Surface(color = greyDark) {
                Column() {
                    Row() {
                        AppBar.mainAppBar(text = "Invite")
                    }
                    Row() {
                        IconaView.icona(
                            text = "Tap to share Invite",
                            drawableId = R.drawable.kompost,
                            onImageClick = { viewModel.generateContentLink() })
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        InviteView()
    }
}





