package com.akshaym.todoistclone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.akshaym.todoistclone.navigation.SetUpNavGraph
import com.akshaym.todoistclone.ui.onboarding.OnboardingView
import com.akshaym.todoistclone.ui.theme.TodoistCloneTheme

class MainActivity : ComponentActivity() {
    lateinit var navBarController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoistCloneTheme {
                navBarController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.i("Inner padding", innerPadding.toString())
                    SetUpNavGraph(navBarController)
//
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoistCloneTheme {
        Greeting("Android")
    }
}