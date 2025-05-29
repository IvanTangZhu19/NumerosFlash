package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.CorrectResponse
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.viewmodels.GameViewModel
import kotlinx.coroutines.delay

@Composable
fun Game(navController: NavController, gameViewModel: GameViewModel){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val nivel = gameViewModel.nivel.collectAsState().value
    if(nivel == null) {
        Text("No se seleccionó un nivel")
        return
    }

    val cantidadOperaciones = nivel.numOperaciones
    val tiempo = nivel.tiempo*1000L
    val rango = nivel.rangoMin..nivel.rangoMax

    var lista_numeros by remember {mutableStateOf(listOf<Int>())}
    var indice by remember {mutableStateOf(0)}
    var mostrarNumero by remember { mutableStateOf(true) }
    var respuesta by remember { mutableStateOf("") }
    var mostrarInput by remember {mutableStateOf(false)}
    var esAcierto by remember {mutableStateOf(false)}
    var validado by remember {mutableStateOf(false)}

    LaunchedEffect(Unit){
        lista_numeros = List(cantidadOperaciones){ rango.random()}
        for(i in 0 until cantidadOperaciones){
            mostrarNumero = true
            delay(tiempo)
            mostrarNumero = false
            delay(500L)
            indice++
        }
        mostrarInput = true
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(navController, scope, drawerState)
        Spacer(modifier = Modifier.height(20.dp))
        if(indice < cantidadOperaciones && mostrarNumero){
            val numeroActual = lista_numeros.getOrNull(indice)
            if(numeroActual != null){
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally).height(200.dp),
                    text= lista_numeros[indice].toString(),
                    fontSize = 70.sp
                )
            }
        } else if (mostrarInput){
            Text("Escribe la respuesta: ", style = MaterialTheme.typography.bodyLarge)
            TextField(
                value = respuesta,
                onValueChange = { respuesta = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Button(
                onClick = {
                    val respuestaCorrecta = lista_numeros.sum()
                    val respuestaInt = respuesta.toIntOrNull()
                    esAcierto = respuestaInt == respuestaCorrecta
                    validado = true
                    mostrarInput = false
                }
            ){
                Text("Validar", style = MaterialTheme.typography.bodyLarge)
            }
        }
        if (validado && respuesta.isNotEmpty()){
            CorrectResponse(esAcierto, lista_numeros, navController)
        }
    }
}