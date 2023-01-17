// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.*
import navigation.controller.NavController
import navigation.controller.NavigationHost
import navigation.controller.composable
import navigation.controller.rememberNavController
import navigation.models.Screen
import navigation.models.ToolbarManuItem

@Composable
fun FirstPage(
    navController: NavController
) {
    Column {
        Text("Main screen nav")
        Button(
            onClick = {
                navController.navigate(Screens.FEED.screen)
            },
            content = {
                Text("Navigate to feed")
            }
        )
    }
}

@Composable
fun FeedScreen(
    navController: NavController
) {
    Text("Feed screen nav")
}

fun main() = application {
    val navController = rememberNavController(Screens.MAIN.screen)
    Window(onCloseRequest = ::exitApplication) {
        AppNavHost(navController.value)
    }
}

enum class Screens(val screen: Screen){
    MAIN(
        Screen(
            title = "Main"
        )
    ),
    FEED(
        Screen(
            title = "Feed",
            menuItems = listOf(
                ToolbarManuItem(
                    label = "Share",
                    icon = Icons.Default.Star,
                    onClick = {
                        println("Hello World")
                    }
                )
            )
        )
    )
}

@Composable
fun AppNavHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screens.MAIN.screen) {
            FirstPage(navController)
        }
        composable(Screens.FEED.screen) {
            FeedScreen(navController)
        }
    }.build()
}
