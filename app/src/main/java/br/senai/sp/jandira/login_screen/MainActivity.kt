package br.senai.sp.jandira.login_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.components.BottomShape
import br.senai.sp.jandira.login_screen.components.TopShape
import br.senai.sp.jandira.login_screen.repository.UserRepository
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

        val context = LocalContext.current

        var emailState by remember{
              mutableStateOf("")}

        var passwordState by remember {
            mutableStateOf("")
        }

        var passwordVisibilityState by remember {
            mutableStateOf(false)
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
                        value = emailState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        onValueChange ={emailState = it},
                        label = { Text(text = stringResource(id = R.string.email))},
                        placeholder = { Text(text = "teste@email.com")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240))}

                    )}

                    OutlinedTextField(
                        value = passwordState,
                        onValueChange ={passwordState = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.password))},
                        placeholder = { Text(text = "****************")},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                        tint = Color(207, 6, 240))},
                        trailingIcon = {
                                       IconButton(
                                           onClick = {
                                            passwordVisibilityState = !passwordVisibilityState
                                       }) {
                                           Icon(
                                               imageVector = if(passwordVisibilityState)
                                                   Icons.Default.VisibilityOff
                                               else{
                                                   Icons.Default.Visibility
                                                   } ,
                                               contentDescription = null
                                           )

                                       }
                        },
                        visualTransformation = if (!passwordVisibilityState)PasswordVisualTransformation()
                        else VisualTransformation.None
                    )




                //button
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(onClick = {
                                         authenticate(emailState,passwordState,context)
                        },
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
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = stringResource(id = R.string.dontHave), color = Color(160,156,156))
                            TextButton(
                                onClick = {
                                    var openSingup = Intent(context, SingUp::class.java)
                                    context.startActivity(openSingup)
                                }
                            ) {
                                Text(text = stringResource(id = R.string.singup), color = Color(207, 6, 240))

                            }
                        }

                        
                    }

                    
                }
            BottomShape()

            }



        }

    }

fun authenticate(email: String, password: String, context: Context) {
    val userRepository =  UserRepository(context)
    val user = userRepository.authenticate(
        email,
        password
    )

    if(user != null){
        var openHome = Intent(context, Home::class.java)
        context.startActivity(openHome)
    }

}

