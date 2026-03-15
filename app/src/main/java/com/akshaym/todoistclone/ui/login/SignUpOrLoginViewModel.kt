package com.akshaym.todoistclone.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpOrLoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginViewState())
        private set

    fun onEmailChanged(newEmail: String) {
        val emailPattern = android.util.Patterns.EMAIL_ADDRESS
        val error = when {
            newEmail.isEmpty() -> null // Don't show error while typing for the first time
            !emailPattern.matcher(newEmail).matches() -> "Invalid email address"
            else -> null
        }

        uiState = uiState.copy(
            email = newEmail, emailError = error ?: ""
        )
        validateForm()
    }

    fun onPasswordChanged(newPassword: String) {
        val error = when {
            newPassword.isEmpty() -> null
            newPassword.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }

        uiState = uiState.copy(
            password = newPassword, passwordError = error ?: ""
        )
        validateForm()
    }

    fun togglePasswordVisibility() {
        uiState = uiState.copy(isPassWordVisible = !uiState.isPassWordVisible)
    }

    private fun validateForm() {
        val isValid =
            uiState.email.isNotEmpty() && uiState.password.isNotEmpty() && uiState.emailError.isEmpty() && uiState.passwordError.isEmpty()

        println(
            """
        --- Form Validation Debug ---
        Email Not Empty:    emailNotEmpty (Value: "${uiState.email.isNotEmpty()}")
        Password Not Empty: passwordNotEmpty (Value: "${uiState.password.isNotEmpty()}
        Email No Error:     emailNoError (Error: "${uiState.emailError}")
        Password No Error:  passwordNoError (Error: "${uiState.passwordError}")
        FINAL IS VALID:     $isValid
        -----------------------------
    """.trimIndent()
        )
        println("isValid" + isValid)
        uiState = uiState.copy(isSubmitEnabled = isValid)
    }
}