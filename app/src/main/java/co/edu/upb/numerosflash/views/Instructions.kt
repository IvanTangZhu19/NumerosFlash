package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.sideMenu

@Composable
fun Instructions(navController: NavController){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val instrucciones = listOf(
        "Observa con atención los números que aparecen.",
        "Suma o resta mentalmente según cada número.",
        "Los números desaparecen rápidamente, ¡concéntrate!",
        "Al final, ingresa el resultado que crees correcto.",
        "¡Compite contra ti mismo o contra otros jugadores!"
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            sideMenu(navController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(navController, scope, drawerState)
            Spacer(modifier = Modifier.height(20.dp))
            Box(Modifier.fillMaxWidth()){
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(36.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                    )
                }
                Text(
                    "Instrucciones",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(
                modifier = Modifier.padding(25.dp).fillMaxHeight()
            ) {
                Text(
                    "¡Bienvenido a NúmerosFlash! Pon a prueba tu agilidad mental y tu capacidad de concentración en este desafío matemático.\n" +
                            "\n" +
                            "\uD83C\uDFAF Objetivo del juego\n" +
                            "Suma o resta los números que irán apareciendo uno por uno en la pantalla. Al final de la secuencia, escribe el resultado final que crees correcto. ¡Gana quien acierte más!\n" +
                            "\n" +
                            "\uD83D\uDCCB ¿Cómo se juega?\n",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Justify
                )
                instrucciones.forEachIndexed { index, texto ->
                    Text(
                        text="${index + 1}. $texto",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                    )
                }
                Text(
                            "\n" +
                            "\uD83E\uDDE9 Modos de juego\n" +
                            "Solitario: Entrena tu mente y trata de superar tu propia puntuación.\n" +
                            "\n" +
                            "Multijugador: Compite en tiempo real con otros jugadores. ¡Gana el más rápido y preciso!",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}