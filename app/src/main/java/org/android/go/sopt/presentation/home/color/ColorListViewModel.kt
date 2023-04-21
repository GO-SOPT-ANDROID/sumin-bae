package org.android.go.sopt.presentation.home.color

import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.Color

class ColorListViewModel : ViewModel() {
    val colorList = listOf(
        Color(name = "Cold Mist", hex = "#EFF8FE"),
        Color(name = "Baby Blue", hex = "#BBE1F5"),
        Color(name = "Afternoon Blue", hex = "#89C3E7"),
        Color(name = "Brisk Blue", hex = "#57C3EA"),
        Color(name = "Comet Blue", hex = "#3AB0E6"),
        Color(name = "Egyptian Blue", hex = "#0081B2"),
        Color(name = "Milky Blue", hex = "#EAF1FA"),
        Color(name = "Frosted Blue", hex = "#AFC3E1"),
        Color(name = "Nostalgic Blue", hex = "#6781B2"),
        Color(name = "Foggy Blue", hex = "#9FB9D0"),
        Color(name = "Light Navy Blue", hex = "#7194B8"),
        Color(name = "Forest Night", hex = "#4B5A6B")
    )
}