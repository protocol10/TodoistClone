package com.akshaym.todoistclone.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.akshaym.todoistclone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    onBackPress: () -> Unit,
    navBarController: NavHostController,
    screenType: String,
    viewModel: SignUpOrLoginViewModel
) {
    val buttonText = if (screenType.lowercase() == "login") {
        "Login"
    } else {
        "Sign Up"
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {}, navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable() {
                            onBackPress.invoke()
                        })
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        )
    }) { innerPadding ->
        val isPasswordVisible = viewModel.uiState.isPassWordVisible
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = buttonText,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .fillMaxWidth(),
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Add your email and password",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.titleLarge,
            )
            OutlinedTextField(
                value = viewModel.uiState.email,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                onValueChange = { it ->
                    viewModel.onEmailChanged(it)
                },
                singleLine = true,
                isError = viewModel.uiState.emailError.isNotEmpty(),
                label = { Text(text = stringResource(id = R.string.str_placeholder_email)) },
                placeholder = { Text(text = stringResource(id = R.string.str_placeholder_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            if (viewModel.uiState.emailError.isNotEmpty()) {
                Text(
                    text = viewModel.uiState.emailError,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp, top = 1.dp, end = 16.dp, bottom = 0.dp)
                )
            }
            OutlinedTextField(
                value = viewModel.uiState.password,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                onValueChange = { it ->
                    viewModel.onPasswordChanged(it)
                },
                isError = viewModel.uiState.passwordError.isNotEmpty(),
                label = { Text(text = stringResource(id = R.string.str_placeholder_password)) },
                placeholder = { Text(text = stringResource(id = R.string.str_placeholder_password)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (isPasswordVisible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description =
                        if (isPasswordVisible) stringResource(R.string.str_content_description_hide_password) else stringResource(
                            R.string.str_content_description_hide_password
                        )

                    IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
                })
            if (viewModel.uiState.passwordError.isNotEmpty()) {
                Text(
                    text = viewModel.uiState.passwordError,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp, top = 1.dp, end = 16.dp, bottom = 0.dp)
                )
            }
            Button(
                onClick = {},
                enabled = viewModel.uiState.isSubmitEnabled,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                content = {
                    Text(text = buttonText)
                })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginView() {
    LoginView(
        onBackPress = {}, navBarController = rememberNavController(), screenType = "login",
        viewModel = viewModel(),
    )
}