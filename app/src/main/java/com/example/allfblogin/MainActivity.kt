package com.example.allfblogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allfblogin.ui.theme.AllFBloginTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            AllFBloginTheme {
                AuthApp()
            }
        }
    }
}

@Composable
fun AuthApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login"){
        composable ("login"){ LoginScreen(navController) }
        composable ("signup"){ SignUpScreen(navController) }
        composable ("home"){ HomeScreen(navController) }
    }
}