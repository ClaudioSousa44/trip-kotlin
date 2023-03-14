package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
                }

                //inputs
                Column (
                    modifier = Modifier.padding(16.dp)
                ) {
                    OutlinedTextField(value = " ",
                        onValueChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.username))},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24) ,
                            contentDescription = null,
                            tint = Color(207, 6, 240))}
                    )
                    OutlinedTextField(value = " ",
                        onValueChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 31.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.phone))},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24) ,
                            contentDescription = null,
                            tint = Color(207, 6, 240))}
                    )
                    OutlinedTextField(value = " ",
                        onValueChange = { },
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
                        value = " ",
                        onValueChange ={},
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
