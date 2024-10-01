package com.samuelokello.flexidocs.ui.navigation

enum class DocumentScreens ( val route: String) {
    Splash("splash"),
    Home("home"),
    Favorites("favorites"),
    BookMark("settings")
}
sealed class Screens ( val route: String) {
    data object Splash : Screens(DocumentScreens.Splash.route)
    data object OverView : Screens(DocumentScreens.Home.route)
    data object Favorites : Screens(DocumentScreens.Favorites.route)
    data object BookMark : Screens(DocumentScreens.BookMark.route)
}