package co.edu.upb.numerosflash.views

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.R
import co.edu.upb.numerosflash.layouts.CorrectResponse
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.sounds.MusicManager
import co.edu.upb.numerosflash.ui.theme.Amarrillo
import co.edu.upb.numerosflash.ui.theme.DarkBlue
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily
import co.edu.upb.numerosflash.ui.theme.Vhite
import co.edu.upb.numerosflash.viewmodels.GameViewModel
import co.edu.upb.numerosflash.viewmodels.UserViewModel
import kotlinx.coroutines.delay

@Composable
fun Game(navController: NavController, gameViewModel: GameViewModel, userViewModel: UserViewModel){
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

    var mensajeInicio by remember { mutableStateOf("¿Estás listo?") }
    var juegoIniciado by remember { mutableStateOf(false) }
    var contador by remember { mutableStateOf(10) }

    LaunchedEffect(Unit){
        //Cuenta regresiva para empezar
        val mensajes = listOf("¿Estás listo?", "Empieza en...", "3", "2", "1", "¡YA!")
        for (i in mensajes) {
            mensajeInicio = i
            delay(1000L)
        }
        juegoIniciado = true

        //Genera los numeros aleatoriamente. Aqui sucede el juego
        lista_numeros = List(cantidadOperaciones){ rango.random()}
        for(i in lista_numeros.indices){
            indice = i
            mostrarNumero = true
            delay(tiempo)
            mostrarNumero = false
            delay(400L)
        }
        mostrarInput = true
    }

    LaunchedEffect(mostrarInput){
        if(mostrarInput){
            for (i in 10 downTo 1){
                contador = i
                delay(1000L)
            }
            if(!validado){
                validado = true
                respuesta = "0"
                esAcierto = false
                mostrarInput = false
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(navController, scope, drawerState)
        Spacer(modifier = Modifier.height(20.dp))
        val context = LocalContext.current
        MusicManager.play(context, nivel.cancion)
        when{
            !juegoIniciado -> {
                Text(
                    mensajeInicio,
                    fontSize = 45.sp,
                    fontFamily = KanitFontFamily
                )
            }
            indice < cantidadOperaciones && mostrarNumero -> {
                val numeroActual = lista_numeros.getOrNull(indice)
                if(numeroActual != null){
                    AnimatedNumber(numero = numeroActual, visible = mostrarNumero)
                }
            }
            mostrarInput ->{
                Text("Escribe la respuesta: ",
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = KanitFontFamily)
                Spacer(Modifier.height(10.dp))
                Text(
                    "⏱️ Tiempo restante: $contador s",
                    style = MaterialTheme.typography.bodyLarge,
                    color = if(contador <=3) Color.Red else White,
                    fontFamily = KanitFontFamily
                )
                Spacer(Modifier.height(15.dp))
                TextField(
                    value = respuesta,
                    onValueChange = { respuesta = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
                Spacer(Modifier.height(15.dp))
                Button(
                    onClick = {
                        val respuestaCorrecta = lista_numeros.sum()
                        val respuestaInt = respuesta.toIntOrNull()
                        esAcierto = respuestaInt == respuestaCorrecta
                        validado = true
                        mostrarInput = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBlue,
                        contentColor = Vhite
                    )
                ){
                    Text(
                        "Validar",
                        style = MaterialTheme.typography.bodyLarge,
                        fontFamily = KanitFontFamily)
                }
            }
            validado && respuesta.isNotEmpty() ->{
                MusicManager.stop()
                CorrectResponse(respuesta.toInt(), esAcierto, lista_numeros, navController, userViewModel)
                LaunchedEffect(validado) {
                    delay(5000L)
                    MusicManager.play(context, R.raw.cherry_cute)
                }
            }
        }
    }
}

@Composable
fun AnimatedNumber(numero: Int, visible: Boolean){
    val animatedProgress by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        contentAlignment = Alignment.Center
    ){

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(500)) + scaleIn(tween(500), initialScale = 0.4f),
                exit = fadeOut(tween(500)) + scaleOut(tween(500), targetScale = 1.5f)
            ){
                Text(
                    text = numero.toString(),
                    fontSize = 140.sp,
                    fontFamily = KanitFontFamily,
                    color = Amarrillo,
                    modifier = Modifier
                        .graphicsLayer {
                            compositingStrategy = CompositingStrategy.Offscreen
                        }
                )
            }
    }
}