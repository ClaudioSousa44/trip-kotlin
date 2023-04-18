package br.senai.sp.jandira.login_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.components.BottomShape
import br.senai.sp.jandira.login_screen.components.TopShape
import br.senai.sp.jandira.login_screen.model.User
import br.senai.sp.jandira.login_screen.repository.UserRepository
import br.senai.sp.jandira.login_screen.ui.theme.ui.theme.LoginscreenTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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


    var usernameState by remember {
        mutableStateOf("")
    }
    var phoneState by remember{
        mutableStateOf("")
    }
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember{
        mutableStateOf(false)
    }

    // Obter foto da galeria de imagens
    var fotoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //Criar o objeto que  abrirá a galeria e retornará a Uri da imagem selecionada
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        fotoUri = it
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(fotoUri).build()
    )

    var context = LocalContext.current

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
               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .verticalScroll(rememberScrollState())
                       .weight(weight = 1f)
               ) {
                   Column (
                       modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Spacer(modifier = Modifier.height(20.dp))
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
                               Image(painter = painter,
                                   contentDescription = null,
                                   modifier = Modifier.padding(16.dp),
                                   contentScale = ContentScale.Crop
                               )
                           }

                           Icon(painter =
                           painterResource(id = R.drawable.img_1),
                               contentDescription = null,
                               modifier = Modifier
                                   .align(Alignment.BottomEnd)
                                   .clickable {
                                              launcher.launch("image/*")
                                   },
                               tint = Color(207, 6, 240)
                           )

                       }
                   }

                   //inputs
                   Column (
                       modifier = Modifier.padding(16.dp)
                   ) {
                       OutlinedTextField(value = usernameState,
                           onValueChange = {usernameState = it },
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(0.dp, 0.dp, 0.dp, 31.dp),
                           shape = RoundedCornerShape(16.dp),
                           label = { Text(text = stringResource(id = R.string.username))},
                           leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24) ,
                               contentDescription = null,
                               tint = Color(207, 6, 240))}
                       )
                       OutlinedTextField(value = phoneState,
                           onValueChange = { phoneState = it},
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(0.dp, 0.dp, 0.dp, 31.dp),
                           shape = RoundedCornerShape(16.dp),
                           label = { Text(text = stringResource(id = R.string.phone))},
                           leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24) ,
                               contentDescription = null,
                               tint = Color(207, 6, 240))},
                           keyboardOptions = KeyboardOptions(
                               keyboardType = KeyboardType.Number
                           )
                       )
                       OutlinedTextField(value = emailState,
                           onValueChange = { emailState= it},
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(0.dp, 0.dp, 0.dp, 31.dp),
                           shape = RoundedCornerShape(16.dp),
                           label = { Text(text = stringResource(id = R.string.email))},
                           leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24) ,
                               contentDescription = null,
                               tint = Color(207, 6, 240))},
                           keyboardOptions = KeyboardOptions(
                               keyboardType = KeyboardType.Email
                           )

                       )
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
                           keyboardOptions = KeyboardOptions(
                               keyboardType = KeyboardType.Password
                           ),
                           visualTransformation = PasswordVisualTransformation()
                       )

                       Row( modifier = Modifier.fillMaxWidth(),
                           verticalAlignment = Alignment.CenterVertically) {
                           Checkbox(checked = over18State, onCheckedChange = {over18State = it} )
                           Text(text = stringResource(id = R.string.over))
                       }

                   }

                   Button(onClick = {
                                    userSave(context, emailState, usernameState,phoneState,passwordState,over18State)
                   },
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
                       TextButton(onClick = {  var openSingin = Intent(context, MainActivity::class.java)
                                                context.startActivity(openSingin)}) {
                           Text(text = stringResource(id = R.string.singin), color = Color(207, 6, 240))
                       }


                   }
                   Spacer(modifier = Modifier.height(20.dp))
               }







           BottomShape()

        }



    }


}

fun userSave(context: Context, email: String, userName: String, phone: String, password: String, isOver: Boolean) {
    val userRepository = UserRepository(context)

    //Recuperando o usuario que tenha o email informado
    var user = userRepository.findUserByEmail(email)

    //Se user for  null, gravamos o novo usuario, senão, avisamos que o usuário ja existe
    if(user == null){
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    }else{
        Toast.makeText(
            context,
            "User already exists!!",
            Toast.LENGTH_LONG
        ).show()
    }
}
