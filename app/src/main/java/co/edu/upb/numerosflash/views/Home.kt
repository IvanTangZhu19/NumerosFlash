package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header

@Composable
fun Home(navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth().padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Header(navController)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Inicio",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}