package co.edu.upb.numerosflash.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CorrectResponse(respuestaUsuario: Int, esAcierto: Boolean, lista_numeros: List<Int>, navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth().padding(25.dp)
    ) {
        Text("La respuesta es: ", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(20.dp))
        Text(
            "${lista_numeros.sum()}",
            fontSize = 120.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        if(esAcierto){
            Text("¡Acertaste!", style = MaterialTheme.typography.headlineSmall)
        } else {
            Text("Lo siento, fallaste. Intentalo de nuevo", style = MaterialTheme.typography.headlineSmall)
        }
        Spacer(Modifier.height(10.dp))
        Text("  Tu respuesta fue: $respuestaUsuario", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            columns = GridCells.Fixed(3),
        ) {
            items(lista_numeros) { num ->
                Text(
                    num.toString(),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {

            }
        ){
            Text("Volver a jugar")
        }
        Button(
            onClick = {
                navController.navigate("levels")
            }
        ){
            Text("Ir a dificultades")
        }
    }
}