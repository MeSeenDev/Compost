package ru.meseen.dev.compost.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.meseen.dev.compost.ui.theme.CompostTheme
import ru.meseen.dev.compost.ui.theme.greyFull
import ru.meseen.dev.compost.ui.theme.greyWhite
import ru.meseen.dev.compost.ui.theme.rubikFamily
import ru.meseen.dev.compost.ui.views.AppBar.mainAppBar

/**
 * @author Vyacheslav Doroshenko
 */
object AppBar {

    @Composable
    fun mainAppBar(text: String) {
        TopAppBar(
            title = {
                Text(
                    text = text,
                    fontFamily = rubikFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = greyWhite
                )
            },
            backgroundColor = greyFull
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultAppBarPreview() {
    CompostTheme() {
        mainAppBar("AppBar")
    }
}