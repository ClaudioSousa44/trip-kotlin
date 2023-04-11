package br.senai.sp.jandira.login_screen.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login_screen.R
import br.senai.sp.jandira.login_screen.model.Categories

class CategoriesRepository {
    companion object{
        @Composable
        fun getCategoriesList(): List<Categories>{
            return listOf<Categories>(
                Categories(
                    id = 1,
                    name = "Montain",
                    image = painterResource(id = R.drawable.baseline_forest_24)
                ),
                Categories(
                    id = 2,
                    name = "Snow",
                    image = painterResource(id = R.drawable.baseline_snowboarding_24)
                ),
                Categories(
                    id = 3,
                    name = "Beach",
                    image = painterResource(id = R.drawable.baseline_beach_access_24)
                ),

            )
        }
    }
}