package com.akshaym.todoistclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akshaym.todoistclone.ui.login.LoginView
import com.akshaym.todoistclone.ui.onboarding.OnboardingView

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
        composable(route = Screen.OnBoarding.route) {
            OnboardingView(navBarController = navController)
        }
        composable(route = Screen.SignUpOrLogin.route) {
            LoginView(onBackPress = { navController.popBackStack() })
        }
    }
}