package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Column() {
                    Surface() {
                        Image(painter = painterResource(id = R.drawable.susanna_profile), contentDescription = "")
                    }
                    
                }


            }
        }

        
    }

}


