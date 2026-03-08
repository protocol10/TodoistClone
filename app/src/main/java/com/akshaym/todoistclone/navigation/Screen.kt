package com.akshaym.todoistclone.navigation


sealed class Screen(val route: String) {

    object OnBoarding : Screen("onboarding")
    object SignUpOrLogin : Screen("login_signup/{screenType}") {
        fun createRoute(screenType: String) = "login_signup/$screenType"
    }
}