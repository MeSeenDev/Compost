package ru.meseen.dev.compost.ui.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.meseen.dev.compost.ui.theme.Shapes
import ru.meseen.dev.compost.ui.theme.accent
import ru.meseen.dev.compost.ui.theme.greyWhite

/**
 * @author Vyacheslav Doroshenko
 */

object IconaView {


    @Composable
    fun icona(text: String, @DrawableRes drawableId: Int, onImageClick: (() -> Unit?)? = null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column() {
                Image(
                    painter = painterResource(id = drawableId),
                    contentDescription = "cat",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .clip(Shapes.large)
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, accent, CircleShape)
                        .fillMaxSize()
                        .clickable {
                            onImageClick?.invoke()
                        },
                    contentScale = ContentScale.Crop,
                )
            }
            Surface(modifier = Modifier.height(8.dp)) {}
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = text, textAlign = TextAlign.Center, color = greyWhite)
            }
        }
    }
}