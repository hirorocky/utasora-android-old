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
package io.github.hirorocky.utasora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.hirorocky.utasora.core.utils.RootUtil
import io.github.hirorocky.utasora.theme.AppTheme
import io.github.hirorocky.utasora.ui.BottomNavBar
import io.github.hirorocky.utasora.ui.MainAnimationNavHost
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private val Tag = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureEdgeToEdgeWindow()

        // Check Rooted Device
        if (RootUtil.isDeviceRooted()) {
            Timber.tag(Tag).e("onCreate - Rooted device.")
            finish()
            return
        }

        Timber.tag(Tag).d("onCreate")

        enableEdgeToEdge()
        setContent {
            AppTheme {
                ChangeSystemBarsTheme(!isSystemInDarkTheme())
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(navController = navController)
                        },
                    ) { innerPaddingModifier ->
                        MainAnimationNavHost(
                            navController = navController,
                            modifier = Modifier
                                .padding(innerPaddingModifier)
                                .background(color = MaterialTheme.colorScheme.surface),
                        )
                    }
                }
            }
        }
    }

    /**
     * Configures our [MainActivity] window so that it reaches edge to edge of the device, meaning
     * content can be rendered underneath the status and navigation bars.
     *
     * This method works hand in hand with [ConfigureTransparentSystemBars], to make sure content
     * behind these bars is visible.
     *
     * Keep in mind that if you need to make sure your content padding doesn't clash with the status bar text/icons,
     * you can leverage modifiers like `windowInsetsPadding()` and `systemBarsPadding()`. For more information,
     * read the Compose WindowInsets docs: https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets
     */
    private fun configureEdgeToEdgeWindow() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    @Composable
    private fun ChangeSystemBarsTheme(lightTheme: Boolean) {
        val statusBarColor = MaterialTheme.colorScheme.background.toArgb()
        val navigationBarColor = MaterialTheme.colorScheme.surfaceVariant.toArgb()
        LaunchedEffect(lightTheme) {
            if (lightTheme) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(
                        statusBarColor,
                        statusBarColor,
                    ),
                    navigationBarStyle = SystemBarStyle.light(
                        navigationBarColor,
                        navigationBarColor,
                    ),
                )
            } else {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        statusBarColor,
                    ),
                    navigationBarStyle = SystemBarStyle.dark(
                        navigationBarColor,
                    ),
                )
            }
        }
    }
}
