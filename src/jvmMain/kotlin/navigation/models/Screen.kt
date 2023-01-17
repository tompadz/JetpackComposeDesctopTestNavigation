package navigation.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

data class Screen(
    val title:String = "Title",
    val icon : ImageVector = Icons.Default.Star,
    var args : Any? = null,
    val hideToolbar: Boolean = false,
    val menuItems: List<ToolbarManuItem> = listOf(),
)
