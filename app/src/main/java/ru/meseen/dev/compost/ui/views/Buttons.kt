package ru.meseen.dev.compost.ui.views


import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.meseen.dev.compost.ui.theme.CompostTheme
import ru.meseen.dev.compost.ui.views.Buttons.corneredButton

/**
 * @author Vyacheslav Doroshenko
 */
object Buttons {


    @Composable
    fun corneredButton(text: String, onClick: () -> Unit) {
        CompostTheme() {
            OutlinedButton(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors()
            ) {
                Text(text = text,modifier = Modifier.padding(start = 24.dp, end = 24.dp))
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultCorneredButtonPreview() {
    corneredButton(text = "Invite", {

    })
}