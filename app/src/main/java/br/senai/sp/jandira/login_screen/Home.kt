package br.senai.sp.jandira.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_screen.model.Categories
import br.senai.sp.jandira.login_screen.model.Trips
import br.senai.sp.jandira.login_screen.repository.CategoriesRepository
import br.senai.sp.jandira.login_screen.repository.TripsRepository
import br.senai.sp.jandira.login_screen.ui.theme.LoginscreenTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginscreenTheme {

                    HomeScreen(CategoriesRepository.getCategoriesList(), TripsRepository.getTripsList())

            }
        }
    }
}


@Composable
fun HomeScreen(categorie: List<Categories>, trip: List<Trips>) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.Magenta) {
                Text(text = "+", color = Color.White)
            }
        }
    ) {

        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it),
            color = Color(238, 237, 237, 255)

        ) {
            Column(modifier = Modifier.fillMaxSize(),
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),

                    ) {
                    Image(painter = painterResource(id = R.drawable.paris),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
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

                        Spacer(modifier = Modifier.size(48.dp))

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

                Spacer(modifier = Modifier.height(13.dp))


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(238, 237, 237, 255)
                ) {
                    Column() {
                        Text(text = stringResource(id =R.string.categories),
                            modifier = Modifier.padding(start = 17.dp)
                        )

                        Spacer(modifier = Modifier.height(13.dp))

                        LazyRow(
                            modifier = Modifier
                                .padding(start = 19.dp)
                        ){
                            items(categorie){
                                    categories ->
                                Card(
                                    modifier = Modifier
                                        .width(109.dp)
                                        .height(64.dp),
                                    backgroundColor = Color.Magenta
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(painter = categories.image ?:
                                        painterResource(
                                            id = R.drawable.baseline_forest_24) ,
                                            contentDescription = "",
                                            tint = Color.White,
                                            modifier = Modifier
                                                .width(32.dp)
                                                .height(32.dp)
                                        )
                                        Text(text = categories.name,
                                            color = Color.White,
                                            fontSize = 14.sp )
                                    }

                                }
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                        OutlinedTextField(
                            value = "" ,
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(17.dp),
                            shape = RoundedCornerShape(16.dp),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_search_24) ,
                                    contentDescription ="",
                                    tint = Color.Gray
                                )
                            },
                            label = {
                                Text(text = stringResource(id = R.string.searchDestiny),
                                    color = Color.Gray)
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.White,
                                backgroundColor = Color.White
                            ),

                            )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = stringResource(id = R.string.pastTrips),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            modifier = Modifier.padding(start = 17.dp)

                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        LazyColumn(
                            modifier = Modifier
                                .padding(start = 17.dp, end = 18.dp)
                        ){
                            items(trip){
                                    trip ->
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .fillMaxWidth(),
                                        verticalArrangement = Arrangement.SpaceBetween

                                    ) {
                                        Image(painter = trip.image ?: painterResource(id = R.drawable.rectangle20),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(106.dp)
                                                .clip(shape = RoundedCornerShape(10.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                        Row() {
                                            Text(
                                                text = trip.place,
                                                fontSize = 14.sp,
                                                color = Color.Magenta,
                                                fontWeight = FontWeight.W400,
                                                lineHeight = 15.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))
                                            Text(
                                                text = trip.year,
                                                fontSize = 14.sp,
                                                color = Color.Magenta,
                                                fontWeight = FontWeight.W400,
                                                lineHeight = 15.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = trip.description,
                                            modifier = Modifier.fillMaxWidth(),
                                            fontSize = 10.sp,
                                            color = Color.Gray,
                                            fontWeight = FontWeight.W400
                                        )
                                        Spacer(modifier = Modifier.width(13.dp))
                                        Text(
                                            text = trip.data,
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Right,
                                            fontSize = 10.sp,
                                            color = Color.Magenta
                                        )

                                    }

                                }
                                Spacer(modifier = Modifier.height(11.dp))
                            }
                        }

                    }
                }


            }
        }
    }

            }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginscreenTheme {
        HomeScreen(
            CategoriesRepository.getCategoriesList(), TripsRepository.getTripsList()
        )
    }
}



