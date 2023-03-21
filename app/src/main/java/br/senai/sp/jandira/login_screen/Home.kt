package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {

                    HomeScreen()

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxSize(),
       ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),

                ) {
                Image(painter = painterResource(id = R.drawable.paris), contentDescription = "" )
                Column(modifier = Modifier.padding(end = 19.dp, top = 13.dp, start = 22.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End) {

                        Surface(modifier = Modifier
                            .height(61.dp)
                            .width(61.dp),
                            shape = CircleShape) {
                            Image(painter = painterResource(id = R.drawable.susanna_profile), contentDescription = "")

                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End) {
                        Text(text = "Susanna Hoffs",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .height(14.dp)
                                .width(14.dp)

                        )
                        Text(text = stringResource(id = R.string.you_are_in_paris),
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Text(text = stringResource(id = R.string.my_trip),
                        color = Color.White,
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp)
                }
            }
        }

        
    }

}


