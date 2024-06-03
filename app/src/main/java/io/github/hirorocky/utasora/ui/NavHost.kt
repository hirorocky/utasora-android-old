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

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.github.hirorocky.utasora.feature.introspection.IntrospectionRoute
import io.github.hirorocky.utasora.feature.phrases.PhrasesRoute
import io.github.hirorocky.utasora.feature.poems.PoemsRoute
import io.github.hirorocky.utasora.feature.settings.SettingsRoute
import io.github.hirorocky.utasora.feature.signin.SignInRoute
import io.github.hirorocky.utasora.feature.signup.SignUpRoute
import io.github.hirorocky.utasora.feature.splash.SplashRoute
import io.github.hirorocky.utasora.feature.title.TitleRoute
import io.github.hirorocky.utasora.navigation.ScreenDestinations
import io.github.hirorocky.utasora.navigation.clearAndNavigateTo
import io.github.hirorocky.utasora.navigation.navigateTo
import io.github.hirorocky.utasora.navigation.screen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainAnimationNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = ScreenDestinations.SplashScreen.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        screen(ScreenDestinations.SplashScreen.route) {
            SplashRoute(
                navigateToTitle = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.TitleScreen.route,
                    )
                },
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PhrasesScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.TitleScreen.route) {
            TitleRoute(
                navigateToSignUp = {
                    navController.navigateTo(ScreenDestinations.SignUpScreen.route)
                },
                navigateToSignIn = {
                    navController.navigateTo(ScreenDestinations.SignInScreen.route)
                },
            )
        }
        screen(ScreenDestinations.SignUpScreen.route) {
            SignUpRoute(
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PoemsScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.SignInScreen.route) {
            SignInRoute(
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PoemsScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.PhrasesScreen.route) {
            PhrasesRoute()
        }
        screen(ScreenDestinations.PoemsScreen.route) {
            PoemsRoute()
        }
        screen(ScreenDestinations.IntrospectionScreen.route) {
            IntrospectionRoute()
        }
        screen(ScreenDestinations.SettingsScreen.route) {
            SettingsRoute(
                navigateToTitle = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.TitleScreen.route,
                    )
                },
            )
        }
    }
}
