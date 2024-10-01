package com.samuelokello.flexidocs.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.samuelokello.flexidocs.ui.navigation.bottom_navigation.StandardScaffold
import com.samuelokello.flexidocs.ui.navigation.bottom_navigation.BottomNavigationItem
import com.samuelokello.flexidocs.ui.presentation.all_files.OverViewScreen
import com.samuelokello.flexidocs.ui.presentation.bookmark.BookMarkScreen
import com.samuelokello.flexidocs.ui.presentation.favourite.FavouritesScreen
import com.samuelokello.flexidocs.ui.presentation.splash.SplashScreen

@Composable
fun FlexiDocsScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStack = navController.currentBackStackEntryAsState()
    val currentRoute = backStack.value?.destination?.route

    var selectedItem by remember { mutableIntStateOf(0) }

    val showBottomBar = currentRoute in listOf(
        Screens.OverView.route,
        Screens.Favorites.route,
        Screens.BookMark.route
    )
    val items = BottomNavigationItem().bottomNavigationItems()

    Scaffold (
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            label = {
                                Text(item.label)
                            },
                            icon = {
                                Icon(painter = painterResource(item.icon), contentDescription = item.label)
                            },
                            selected = index == selectedItem  ,
                            onClick = {
                                selectedItem = index
                                val screen = when (item.route) {
                                    Screens.OverView.route -> Screens.OverView
                                    Screens.Favorites.route -> Screens.Favorites
                                    Screens.BookMark.route -> Screens.BookMark
                                    else -> null
                                }
                                screen?.let { navController.navigate(it.route) }
                            }
                        )
                    }
                }
            }
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Screens.Splash.route) {
                var splashVisible by remember { mutableStateOf(true) }

                AnimatedVisibility(visible = splashVisible) {
                    SplashScreen(
                        modifier = Modifier.padding(innerPadding),
                        navigateToHome = {
                            splashVisible = false
                            navController.navigate(Screens.OverView.route) {
                                popUpTo(Screens.Splash.route) { inclusive = true }
                            }
                        }
                    )
                }
            }
            composable(route = Screens.OverView.route) {
                OverViewScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(route = Screens.Favorites.route) {
                FavouritesScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(route = Screens.BookMark.route) {
                BookMarkScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }

        }
    }
}