package com.akshaym.todoistclone.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.akshaym.todoistclone.ui.login.LoginView
import com.akshaym.todoistclone.ui.login.SignUpOrLoginViewModel
import com.akshaym.todoistclone.ui.onboarding.OnboardingView

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
        composable(route = Screen.OnBoarding.route) {
            OnboardingView(navBarController = navController)
        }
        composable(
            route = Screen.SignUpOrLogin.route,
            arguments = listOf(navArgument("screenType") {
                type = NavType.StringType
            })
        ) { backstackEntry ->
            val screenType = backstackEntry.arguments?.getString("screenType")
            LoginView(
                navBarController = navController,
                onBackPress = { navController.popBackStack() },
                screenType = screenType ?: "login",
                viewModel = viewModel(),
            )
        }
    }
}