package co.edu.upb.numerosflash.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

@Composable
fun CorrectResponse(esAcierto: Boolean, lista_numeros: List<Int>, navController: NavController){
    Column {
        Text("La respuesta es: ", style = MaterialTheme.typography.headlineSmall)
        Text("${lista_numeros.sum()}", fontSize = 70.sp)
        if(esAcierto){
            Text("¡Acertaste!", style = MaterialTheme.typography.headlineSmall)
        } else {
            Text("Lo siento, fallaste. Intentalo de nuevo", style = MaterialTheme.typography.headlineSmall)
        }
    }
}