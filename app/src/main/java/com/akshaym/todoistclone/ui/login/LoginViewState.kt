package com.akshaym.todoistclone.ui.login

data class LoginViewState(
    val email: String = "",
    val password: String = "",
    val isPassWordVisible: Boolean = false,
    val isSubmitEnabled: Boolean = false,
    val showEmailError: Boolean = false,
    val emailError: String = "",
    val passwordError: String = ""
)