package navigation.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

data class ToolbarManuItem(
    val label:String = "",
    val icon : ImageVector = Icons.Default.Star,
    val onClick : () -> Unit
)
