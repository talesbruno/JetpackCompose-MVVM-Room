package co.talesbruno.notes.ui.menu

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String
)
