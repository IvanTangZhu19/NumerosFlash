package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.LevelItem
import co.edu.upb.numerosflash.layouts.sideMenu

@Composable
fun Levels(navController: NavController){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            sideMenu(navController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(navController, scope, drawerState)
            Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Selecciona la dificultad",
                    style = MaterialTheme.typography.headlineMedium,
                )
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(10.dp).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ){
                LevelItem(
                    "\uD83D\uDC22 Calentamiento ",
                    "Ideal para empezar. Números pequeños, tiempo amplio y pocas operaciones." +
                            "\nTiempo: 8 s" +
                            "\n Nivel 1: " +
                            "\n   - Rango: 1, 20" +
                            "\n   - Cantidad de operaciones: 5"+
                            "\n Nivel 2: " +
                            "\n   - Rango: 1, 50" +
                            "\n   - Cantidad de operaciones: 5"+
                            "\n Nivel 3: " +
                            "\n   - Rango: -50, 50" +
                            "\n   - Cantidad de operaciones: 10"+
                            "\n Nivel 4: " +
                            "\n   - Rango: -100,100" +
                            "\n   - Cantidad de operaciones: 10"
                )
                LevelItem(
                    "\uD83C\uDFC3\u200D♂\uFE0F Desafío Rápido",
                    "Un nivel intermedio con números más grandes y menos tiempo para responder." +
                            "\nTiempo: 5 s" +
                            "\n Nivel 1: " +
                            "\n   - Rango: 1, 50" +
                            "\n   - Cantidad de operaciones: 5"+
                            "\n Nivel 2: " +
                            "\n   - Rango: 1, 100" +
                            "\n   - Cantidad de operaciones: 10"+
                            "\n Nivel 3: " +
                            "\n   - Rango: -50, 50" +
                            "\n   - Cantidad de operaciones: 10"+
                            "\n Nivel 4: " +
                            "\n   - Rango: -100,100" +
                            "\n   - Cantidad de operaciones: 15"
                )
                LevelItem(
                    "\uD83C\uDF29\uFE0F Relámpago",
                    "Los números aparecen más rápido. Debes estar muy concentrado."+
                            "\nTiempo: 3 s" +
                            "\n Nivel 1: " +
                            "\n   - Rango: 1, 50" +
                            "\n   - Cantidad de operaciones: 5"+
                            "\n Nivel 2: " +
                            "\n   - Rango: 1, 100" +
                            "\n   - Cantidad de operaciones: 10"+
                            "\n Nivel 3: " +
                            "\n   - Rango: -100, 100" +
                            "\n   - Cantidad de operaciones: 15"+
                            "\n Nivel 4: " +
                            "\n   - Rango: -150,150" +
                            "\n   - Cantidad de operaciones: 20"
                )
                LevelItem(
                    "⚡\uFE0F Flash",
                    "Modo extremo: operaciones complejas, números grandes y muy poco tiempo."+
                            "\nTiempo: 1 s" +
                            "\n Nivel 1: " +
                            "\n   - Rango: 1, 50" +
                            "\n   - Cantidad de operaciones: 5"+
                            "\n Nivel 2: " +
                            "\n   - Rango: 1, 100" +
                            "\n   - Cantidad de operaciones: 10"+
                            "\n Nivel 3: " +
                            "\n   - Rango: -50, 50" +
                            "\n   - Cantidad de operaciones: 15"+
                            "\n Nivel 4: " +
                            "\n   - Rango: -250,250" +
                            "\n   - Cantidad de operaciones: 20"
                )
                Button(
                    onClick= {}
                ) {
                    Text("Personalizado", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}