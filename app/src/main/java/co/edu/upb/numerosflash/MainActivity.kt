package co.edu.upb.numerosflash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.upb.numerosflash.ui.theme.NumerosFlashTheme
import co.edu.upb.numerosflash.viewmodels.GameViewModel
import co.edu.upb.numerosflash.views.Credits
import co.edu.upb.numerosflash.views.Game
import co.edu.upb.numerosflash.views.Home
import co.edu.upb.numerosflash.views.Login
import co.edu.upb.numerosflash.views.Register
import co.edu.upb.numerosflash.views.Instructions
import co.edu.upb.numerosflash.views.Levels
import co.edu.upb.numerosflash.views.Multiplayer
import co.edu.upb.numerosflash.views.Profile
import co.edu.upb.numerosflash.views.TipsTricks

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumerosFlashTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val gameViewModel: GameViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = "login",
        //startDestination = if (authState != null) "home" else "login",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("login") {
            Login(navController)
        }
        composable("register") {
            Register(navController)
        }
        composable("home") {
            Home(navController)
        }
        composable("credits") {
            Credits(navController)
        }
        composable("instructions") {
            Instructions(navController)
        }
        composable("profile") {
            Profile(navController)
        }
        composable("tips") {
            TipsTricks(navController)
        }
        composable("levels") {
            Levels(navController, gameViewModel)
        }
        composable("game") {
            Game(navController, gameViewModel)
        }
        composable("multiplayer") {
            Multiplayer(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    NumerosFlashTheme {
        Navigation()
    }
}