package navigation.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import navigation.models.Screen

class NavController(
    private val startDestination : Screen,
    private var backStackScreen: MutableSet<Screen> = mutableSetOf(),
) {

    val isLastPage get() = backStackScreen.isEmpty()
    var currentScreen : MutableState<Screen> = mutableStateOf(startDestination)

    fun navigate(route : Screen) {
        if (route != currentScreen.value) {
            if (backStackScreen.contains(currentScreen.value) && currentScreen.value != startDestination) {
                backStackScreen.remove(currentScreen.value)
            }
            if (route == startDestination) {
                backStackScreen = mutableSetOf()
            }else {
                backStackScreen.add(currentScreen.value)
            }
            currentScreen.value = route
        }
    }

    fun navigateBack() {
        if (backStackScreen.isNotEmpty()) {
            currentScreen.value = backStackScreen.last()
            backStackScreen.remove(currentScreen.value)
        }
    }
}

@Composable
fun rememberNavController(
    startDestination: Screen,
    backStackScreen: MutableSet<Screen> = mutableSetOf()
): MutableState<NavController> = rememberSaveable {
    mutableStateOf(
        NavController(
            startDestination,
            backStackScreen
        )
    )
}