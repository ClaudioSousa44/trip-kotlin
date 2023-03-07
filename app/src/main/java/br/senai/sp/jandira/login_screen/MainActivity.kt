package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {
                LoginScreen()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun  LoginScreen() {
    Surface(
        modifier = Modifier.
                fillMaxSize()
    ) {
        Column(
            modifier = Modifier.
            fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.
                fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                            ,
                            color = Color(207, 6, 240),
                    shape = RoundedCornerShape(
                        bottomStart = 16.dp
                    )
                ) {}
            }
            //Column main
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp, 0.dp),

            ) {
                //text-login
                Column() {
                    Text(text = "Login",
                        color = Color(207, 6, 240),
                        fontSize = 48.sp,
                        fontWeight = FontWeight(700)
                    )
                    Text(text = "Please sign in to continue.",
                        color = Color(160,156,156),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 87.dp)
                    )
                }
                // outline-texfilds
                Column(
                    modifier = Modifier
                ) {
                    OutlinedTextField(
                        value = " ",
                        modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        onValueChange ={},
                        label = { Text(text = "E-mail")},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))}

                    )}

                    OutlinedTextField(
                        value = " ",
                        onValueChange ={},
                        modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = "Password")},
                        placeholder = { Text(text = "****************")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                        tint = Color(207, 6, 240))}
                        )


                //button
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 31.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(text = "SIGN IN",
                                   color = Color.White,
                                   modifier = Modifier.padding(9.dp, 0.dp))
                                Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                                    contentDescription = null,
                                tint = Color.White)
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = "Don't have an account? ", color = Color(160,156,156))
                            Text(text = "Sign up", color = Color(207, 6, 240))
                        }

                        
                    }

                    
                }
            Surface(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp)
                ,
                color = Color(207, 6, 240),
                shape = RoundedCornerShape(
                    topEnd = 16.dp
                )
            ) {}

            }



        }

    }

