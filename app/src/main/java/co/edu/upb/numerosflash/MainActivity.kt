package co.edu.upb.numerosflash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.upb.numerosflash.ui.theme.NumerosFlashTheme
import co.edu.upb.numerosflash.views.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumerosFlashTheme {
                Navegacion()
            }
        }
    }
}

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
        //startDestination = if (authState != null) "home" else "login",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("login") {
            Login(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumerosFlashTheme {
        Navegacion()
    }
}