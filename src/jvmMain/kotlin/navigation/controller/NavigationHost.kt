package navigation.controller

import Toolbar
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import navigation.models.Screen

class NavigationHost(
    val navController: NavController,
    val contents: @Composable NavigationGraphBuilder.() -> Unit
) {
    @Composable
    fun build() {
        NavigationGraphBuilder().renderContents()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavigationHost.navController
    ) {
        @Composable
        fun renderContents() {
            this@NavigationHost.contents(this)
        }
    }
}

@Composable
fun NavigationHost.NavigationGraphBuilder.composable(
    route: Screen,
    content: @Composable () -> Unit
) {
    if (navController.currentScreen.value == route) {
        if (!route.hideToolbar) {
            Column {
                Toolbar(navController, route)
                content()
            }
        } else {
            content()
        }
    }
}

