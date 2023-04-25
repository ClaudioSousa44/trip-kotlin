package br.senai.sp.jandira.login_screen.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.Year

data class Trips(
    var id: Long = 0,
    var place: String = "",
    var image: Painter? = null,
    var year: String = "",
    var data: String = "",
    var description: String = ""

) {

}