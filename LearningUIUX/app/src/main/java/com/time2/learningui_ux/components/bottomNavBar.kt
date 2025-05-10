package com.time2.learningui_ux.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.time2.learningui_ux.GreetingPreview


data class BottonNavigationItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun bottomNavBar(
    items: List<BottonNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    content: @Composable (Modifier) -> Unit)
{
        NavigationBar{
            items.forEachIndexed {index, item ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                        onItemSelected(index)
                    },
                    label = { Text(text = item.title) },
                    icon = {
                        BadgedBox(
                            badge = {
                                if (item.badgeCount != null) {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }
                                }else if(item.hasNews){
                                    Badge()
                                }
                            }
                        ) {
                            val icon = if (index == selectedIndex) item.selectedIcon else item.unselectedIcon
                            val iconTint = if (index == selectedIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface

                            Icon(
                                imageVector = icon,
                                contentDescription = item.title,
                                tint = iconTint
                            )
                        }
                    }
                )
            }
        }
}

@Composable
fun buildBottomBar()
{
    val items = listOf(
        BottonNavigationItem("Home", Icons.Filled.Home, Icons.Outlined.Home, false, null),
        BottonNavigationItem("Senhas", Icons.Filled.Lock, Icons.Outlined.Lock, false, 25),
        BottonNavigationItem("Configurações", Icons.Filled.Settings, Icons.Outlined.Settings, true, null)
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf( 0 ) }

    bottomNavBar(
        items = items,
        selectedIndex = selectedItemIndex,
        onItemSelected = { index -> selectedItemIndex = index }
    ) { modifier ->
        when (selectedItemIndex) {
            0 -> GreetingPreview(modifier)
            1 -> GreetingPreview(modifier)
            2 -> GreetingPreview(modifier)
        }
    }
}