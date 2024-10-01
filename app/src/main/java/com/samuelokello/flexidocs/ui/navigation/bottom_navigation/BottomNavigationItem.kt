package com.samuelokello.flexidocs.ui.navigation.bottom_navigation

import com.samuelokello.flexidocs.R
import com.samuelokello.flexidocs.ui.navigation.DocumentScreens

data class BottomNavigationItem (
    val label : String = "",
    val icon : Int = 0,
    val route : String = ""
){
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem("All Files", R.drawable.ic_home, DocumentScreens.Home.route),
            BottomNavigationItem("Favorites", R.drawable.ic_favourite, DocumentScreens.Favorites.route),
            BottomNavigationItem("Book Mark", R.drawable.ic_bookmark, DocumentScreens.BookMark.route)
        )
    }
}