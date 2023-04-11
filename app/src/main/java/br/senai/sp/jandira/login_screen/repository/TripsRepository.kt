package br.senai.sp.jandira.login_screen.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login_screen.R
import br.senai.sp.jandira.login_screen.model.Trips

class TripsRepository {
    companion object{
        @Composable
        fun getTripsList(): List<Trips>{
            return listOf<Trips>(
                Trips(
                    id = 1,
                    place = "London",
                    image = painterResource(id = R.drawable.rectangle20),
                    year = "2019",
                    data = "18 fab - 21 fab",
                    description = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
                ),
                Trips(
                    id = 2,
                    place = "Porto",
                    image = painterResource(id = R.drawable.rectangle22),
                    year = "2022",
                    data = "18 fab - 21 fab",
                    description = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas."
                )
            )
        }
    }
}