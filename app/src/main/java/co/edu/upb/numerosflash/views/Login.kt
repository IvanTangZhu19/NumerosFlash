package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Text("Login")
        Button(
            onClick = {navController.navigate("home")}
        ) { }
    }

}