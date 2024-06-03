/*
* MIT License
*
* Copyright (c) 2024 Hridoy Chandra Das
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*
*/
package io.github.hirorocky.utasora.ui

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Note
import androidx.compose.material.icons.automirrored.outlined.Note
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.github.hirorocky.utasora.R
import io.github.hirorocky.utasora.navigation.ScreenDestinations
import io.github.hirorocky.utasora.navigation.clearAndNavigateTo
import io.github.hirorocky.utasora.theme.AppTheme

@Composable
fun BottomNavBar(navController: NavHostController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination
        BottomNavItems.entries.forEach { item ->
            val isActive = currentDestination?.hierarchy?.any { it.route == item.destination.route } == true
            NavigationBarItem(
                selected = isActive,
                onClick = {
                    navController.clearAndNavigateTo(
                        route = item.destination.route,
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (isActive) {
                            item.iconActive
                        } else {
                            item.iconInactive
                        },
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        contentDescription = stringResource(id = item.titleId),
                    )
                },
                enabled = true,
                label = {
                    Text(
                        text = stringResource(id = item.titleId),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.labelSmall,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.tertiaryContainer,
                ),
            )
        }
    }
}

enum class BottomNavItems(
    val destination: ScreenDestinations,
    val iconActive: ImageVector,
    val iconInactive: ImageVector,
    @StringRes val titleId: Int,
) {
    Phrases(
        destination = ScreenDestinations.PhrasesScreen,
        iconActive = Icons.AutoMirrored.Filled.Note,
        iconInactive = Icons.AutoMirrored.Outlined.Note,
        titleId = R.string.menu_phrases,
    ),
    Poems(
        destination = ScreenDestinations.PoemsScreen,
        iconActive = Icons.Filled.LocalLibrary,
        iconInactive = Icons.Outlined.LocalLibrary,
        titleId = R.string.menu_poems,
    ),
    Introspection(
        destination = ScreenDestinations.IntrospectionScreen,
        iconActive = Icons.Filled.Psychology,
        iconInactive = Icons.Outlined.Psychology,
        titleId = R.string.menu_introspection,
    ),
    Settings(
        destination = ScreenDestinations.SettingsScreen,
        iconActive = Icons.Filled.Settings,
        iconInactive = Icons.Outlined.Settings,
        titleId = R.string.menu_settings,
    ),
}

@Preview(widthDp = 375, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomNavBarDarkPreview() {
    AppTheme {
        BottomNavBar(navController = NavHostController(context = LocalContext.current))
    }
}

@Preview(widthDp = 375, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun BottomNavBarLightPreview() {
    AppTheme {
        BottomNavBar(navController = NavHostController(context = LocalContext.current))
    }
}
