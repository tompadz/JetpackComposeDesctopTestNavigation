import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import navigation.controller.NavController
import navigation.models.Screen

@Composable
fun Toolbar(
    navController: NavController,
    screen: Screen,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .shadow(elevation = 4.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .defaultMinSize(minHeight = 56.dp)
            .padding(16.dp)
    ) {
        if (! navController.isLastPage) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        navController.navigateBack()
                    }
            )
            Spacer(Modifier.width(32.dp))
        }
        Text(
            text = screen.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onPrimary
        )
        if (screen.menuItems.isNotEmpty()) {
            Spacer(Modifier.width(16.dp))
            Spacer(Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                screen.menuItems.forEachIndexed { index, it ->
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.label,
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable { it.onClick() }
                    )
                    if (index != screen.menuItems.size - 1) {
                        Spacer(Modifier.width(24.dp))
                    }
                }
            }
        }
    }
}