package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.components.BottomShape
import br.senai.sp.jandira.login_screen.components.TopShape
import br.senai.sp.jandira.login_screen.ui.theme.ui.theme.LoginscreenTheme

class SingUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {
                SingUpScreen()

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingUpScreen(){
    var usernameState =  rememberSaveable {
        mutableStateOf("")
    }
    var phoneState =  rememberSaveable {
        mutableStateOf("")
    }
    var emailState =  rememberSaveable {
        mutableStateOf("")
    }
    var passwordState =  rememberSaveable {
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


                //title page
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(id = R.string.singup),
                        color = Color(207, 6, 240),
                        fontSize = 32.sp,
                        fontWeight = FontWeight(700))
                    Text(text = stringResource(id = R.string.create),
                        color = Color(160,156,156),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp))
                    Box(){
                        Card(modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopCenter),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 1.dp,
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Magenta, Color.White
                                    )
                                )
                            )
                        ) {
                            Image(painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = null,
                                modifier = Modifier.padding(16.dp)
                               )
                        }

                            Icon(painter =
                            painterResource(id = R.drawable.img_1),
                                contentDescription = null,
                                modifier = Modifier
                                .align(Alignment.BottomEnd),
                                tint = Color(207, 6, 240)
                            )

                    }
                }

                //inputs
                Column (
                    modifier = Modifier.padding(16.dp)
                ) {
                    OutlinedTextField(value = usernameState.value,
                        onValueChange = {usernameState.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.username))},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24) ,
                            contentDescription = null,
                            tint = Color(207, 6, 240))}
                    )
                    OutlinedTextField(value = phoneState.value,
                        onValueChange = { phoneState.value = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.phone))},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24) ,
                            contentDescription = null,
                            tint = Color(207, 6, 240))}
                    )
                    OutlinedTextField(value = emailState.value,
                        onValueChange = { emailState.value = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.email))},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24) ,
                            contentDescription = null,
                            tint = Color(207, 6, 240))}
                    )
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

                    Row( modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = false, onCheckedChange = {} )
                        Text(text = stringResource(id = R.string.over))
                    }

                }

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 16.dp, 31.dp)
                        .fillMaxWidth()) {
                    Text(text = stringResource(id = R.string.createAccount).uppercase(), color = Color.White)

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 16.dp, 0.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = stringResource(id = R.string.always), color = Color(160,156,156))
                    Text(text = stringResource(id = R.string.singin), color = Color(207, 6, 240))
                }







           BottomShape()

        }



    }


}
