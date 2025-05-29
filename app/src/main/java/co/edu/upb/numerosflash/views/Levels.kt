package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
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
import co.edu.upb.numerosflash.models.Difficulty
import co.edu.upb.numerosflash.models.Level
import androidx.compose.foundation.lazy.items
import co.edu.upb.numerosflash.viewmodels.GameViewModel

@Composable
fun Levels(navController: NavController, gameViewModel: GameViewModel){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            sideMenu(navController)
        },
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
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
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxHeight(),
            ){
                LazyColumn {
                    items(dificultades) { index ->
                        LevelItem(
                            index.titulo,
                            index.descripcion + "\n" +
                                    "Tiempo: ${index.levels[0].tiempo} segundos}" +
                                    "\nNivel ${index.levels[0].id}" +
                                    "\n  - Rango: ${index.levels[0].rangoMin} - ${index.levels[0].rangoMax}" +
                                    "\n  - Operaciones: ${index.levels[0].numOperaciones}" +
                                    "\nNivel ${index.levels[1].id}" +
                                    "\n  - Rango: ${index.levels[1].rangoMin} - ${index.levels[1].rangoMax}" +
                                    "\n  - Operaciones: ${index.levels[1].numOperaciones}" +
                                    "\nNivel ${index.levels[2].id}" +
                                    "\n  - Rango: ${index.levels[2].rangoMin} - ${index.levels[2].rangoMax}" +
                                    "\n  - Operaciones: ${index.levels[2].numOperaciones}" +
                                    "\nNivel ${index.levels[3].id}" +
                                    "\n  - Rango: ${index.levels[3].rangoMin} - ${index.levels[3].rangoMax}" +
                                    "\n  - Operaciones: ${index.levels[3].numOperaciones}",
                            navController,
                            index.levels,
                            onLevelSelected = { level ->
                                gameViewModel.seleccionarNivel(level)
                                navController.navigate("game")
                            }
                        )
                    }
                }
                Button(
                    onClick= {}
                ) {
                    Text("Personalizado", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

val dificultades = listOf<Difficulty>(
    Difficulty(
        "\uD83D\uDC22 Calentamiento",
        "Ideal para empezar. Números pequeños, tiempo amplio y pocas operaciones.",
        listOf<Level>(
            Level(1, 1, 20, 8, 5),
            Level(2, 1, 50, 8, 5),
            Level(3, -50, 50, 8, 10),
            Level(4, -100, 100, 8, 10)
        )
    ),
    Difficulty(
        "\uD83C\uDFC3\u200D♂\uFE0F Desafío Rápido",
        "Un nivel intermedio con números más grandes y menos tiempo para responder.",
        listOf<Level>(
            Level(1, 1, 20, 5, 5),
            Level(2, 1, 50, 5, 10),
            Level(3, -50, 50, 5, 15),
            Level(4, -100, 100, 5, 15)
        )
    ),
    Difficulty(
        "\uD83C\uDF29\uFE0F Relámpago",
        "Los números aparecen más rápido. Debes estar muy concentrado.",
        listOf<Level>(
            Level(1, 1, 50, 5, 5),
            Level(2, 1, 100, 5, 5),
            Level(3, -50, 50, 5, 10),
            Level(4, -150, 150, 5, 15)
        )
    ),
    Difficulty(
        "⚡\uFE0F Flash",
        "Modo extremo: operaciones complejas, números grandes y muy poco tiempo.",
        listOf<Level>(
            Level(1, 1, 50, 1, 10),
            Level(2, 1, 100, 1, 10),
            Level(3, -100, 100, 1, 15),
            Level(4, -200, 200, 1, 20)
        )
    ),
)