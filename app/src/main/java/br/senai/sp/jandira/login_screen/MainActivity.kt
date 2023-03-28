package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.components.BottomShape
import br.senai.sp.jandira.login_screen.components.TopShape
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

        var emailState = rememberSaveable()
              {mutableStateOf("")}

        var passwordState = rememberSaveable {
            mutableStateOf("")
        }
            

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
                TopShape()
            }
            //Column main
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp, 0.dp),

            ) {
                //text-login
                Column() {
                    Text(text = stringResource(id = R.string.login),
                        color = Color(207, 6, 240),
                        fontSize = 48.sp,
                        fontWeight = FontWeight(700)
                    )
                    Text(text = stringResource(id = R.string.please),
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
                        value = emailState.value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        onValueChange ={emailState.value = it},
                        label = { Text(text = stringResource(id = R.string.email))},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))}

                    )}

                    OutlinedTextField(
                        value = passwordState.value,
                        onValueChange ={passwordState.value = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.password))},
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
                                Text(text = stringResource(id = R.string.singin).uppercase(),
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
                            Text(text = stringResource(id = R.string.dontHave), color = Color(160,156,156))
                            Text(text = stringResource(id = R.string.singup), color = Color(207, 6, 240))
                        }

                        
                    }

                    
                }
            BottomShape()

            }



        }

    }

