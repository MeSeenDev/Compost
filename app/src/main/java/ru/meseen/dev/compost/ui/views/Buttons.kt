package ru.meseen.dev.compost.ui.views

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.meseen.dev.compost.R
import ru.meseen.dev.compost.ui.theme.CompostTheme

/**
 * @author Vyacheslav Doroshenko
 */
class Buttons {


    @Composable
    fun corneredButton(text: String, onClick: () -> Unit){
        CompostTheme() {


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        corneredButton(text = "Invite", {
          //ignore
        })
    }
}