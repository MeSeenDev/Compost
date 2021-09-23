package ru.meseen.dev.compost

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.meseen.dev.compost.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompostTheme() {

            }
        }
    }


    fun click() {
        Toast.makeText(this, "Компост", Toast.LENGTH_SHORT)
            .show()
    }

}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            card(message)
        }
    }
}

@Composable
fun hello(){

}

@Composable
fun card(message: Message) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Icon",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(4.dp, MaterialTheme.colors.secondary, CircleShape)
                .fillMaxSize(),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Text(
                text = message.author,
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = MaterialTheme.colors.secondary,
                fontFamily = rubikFamily
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Column() {
            Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = descColor,
                    modifier = Modifier.padding(8.dp),
                    fontFamily = rubikFamily
                )
            }
        }
    }
}


data class Message(val author: String = "anonim", val message: String = "empty message")

@Preview
@Composable
fun PreviewConversation() {
    CompostTheme() {
        Conversation(
            listOf(
                Message(
                    author = "Джон Бобс",
                    message = "A chat with one message feels a bit lonely, so let’s change our conversation to have more than one message. We need to create"
                ),
                Message(
                    author = "Джон Бобс", message = "Create a list of messages\n" +
                            "A chat with one message feels a bit lonely, so let’s change our conversation to have more than one message. We need to create a Conversation function that will show multiple messages. For this use case, we"
                ),
                Message(
                    author = "Джон Бобс",
                    message = "can use Compose’s LazyColumn and LazyRow. These composables render only the elements that are visible on screen, so"
                ),
                Message(
                    author = "Джон Бобс",
                    message = "they are designed to be very efficient for long lists. At the same time, they avoid the complexity of RecyclerView with XML layouts"
                ),
                Message(
                    author = "Джон Бобс",
                    message = "In this code snippet, you can see that LazyColumn has an items child. It takes a List as a parameter and its lambda"
                ),

                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompostTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            shape = Shapes.medium,
            border = BorderStroke(3.dp, Purple200)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.cat),
                        contentDescription = "cat",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .clip(Shapes.large)
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Surface(modifier = Modifier.width(8.dp)){}
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Fuck Compose",textAlign = TextAlign.Center)
                }
            }

        }
    }
}
