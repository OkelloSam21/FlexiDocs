package com.samuelokello.flexidocs.ui.navigation.bottom_navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.samuelokello.flexidocs.ui.navigation.DocumentScreens
import com.samuelokello.flexidocs.ui.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    items: List<BottomNavigationItem>,
    onItemClick : (Screens) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar =  {
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
                                DocumentScreens.Home.route -> Screens.OverView
                                DocumentScreens.Favorites.route -> Screens.Favorites
                                DocumentScreens.BookMark.route -> Screens.BookMark
                                else -> null
                            }
                            onItemClick(screen!!)
                        }
                    )
                }
            }
        }
    ) {
        content(it)
    }

}

@Preview(showBackground = true)
@Composable
fun BottomBarPrev () {
    StandardScaffold(
        items = BottomNavigationItem().bottomNavigationItems(),
        onItemClick = {},
        content = {}
    )
}