package br.senai.sp.jandira.login_screen.model

import androidx.compose.ui.graphics.painter.Painter

data class Categories
    (var id: Long = 0,
    var name: String = "",
    var image: Painter? = null   )
{}