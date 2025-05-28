package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.sideMenu

@Composable
fun TipsTricks(navController: NavController){
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
                    "Trucos y consejos",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                "¿Quieres mejorar tu puntuación en NúmerosFlash? Aquí te dejamos algunos consejos que pueden marcar la diferencia:\n" +
                        "\n" +
                        "\uD83E\uDDE0 1. Concéntrate en los signos\n" +
                        "Cada número puede ser positivo o negativo. ¡Un solo signo puede cambiarlo todo! Presta atención a los símbolos + y –, especialmente cuando los números aparecen rápido.\n" +
                        "\n" +
                        "\uD83D\uDC41\uFE0F 2. No intentes memorizar, piensa en bloques\n" +
                        "En lugar de recordar cada número individualmente, agrúpalos mentalmente. Por ejemplo, si ves +3, –2, +1, puedes pensar: “3 menos 2 más 1 = 2”. Esto reduce la carga mental.\n" +
                        "\n" +
                        "⏳ 3. Mantén la calma con el tiempo\n" +
                        "No te desesperes si el número desaparece rápido. El objetivo es entrenar tu agilidad mental, no tu memoria visual. Respira y mantén el ritmo.\n" +
                        "\n" +
                        "\uD83D\uDCD3 4. Practica primero en niveles fáciles\n" +
                        "Empieza en una dificultad baja para acostumbrarte al ritmo del juego. Luego aumenta el rango de números o la velocidad a medida que te sientas más cómodo.\n" +
                        "\n" +
                        "\uD83D\uDC65 5. Observa a tus oponentes en el multijugador\n" +
                        "En partidas multijugador, no solo cuenta la velocidad, también la precisión. A veces, ser un poco más lento pero certero te da más puntos que responder rápido y mal.\n" +
                        "\n" +
                        "\uD83D\uDCC8 6. Revisa tus estadísticas\n" +
                        "Mira tus partidas anteriores. ¿En qué tipo de operaciones fallas más? ¿Sumas? ¿Restas? Usa esa información para mejorar.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}