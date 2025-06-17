package co.edu.upb.numerosflash.layouts

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.edu.upb.numerosflash.sounds.SoundManager
import co.edu.upb.numerosflash.ui.theme.DarkBlue
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily
import co.edu.upb.numerosflash.ui.theme.Vhite
import co.edu.upb.numerosflash.viewmodels.UserViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.scale
import co.edu.upb.numerosflash.ui.theme.Amarrillo

@Composable
fun CorrectResponse(
        respuestaUsuario: Int,
        esAcierto: Boolean,
        lista_numeros: List<Int>,
        navController: NavController,
        userViewModel: UserViewModel
    ){
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "La respuesta es: ",
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = KanitFontFamily
        )
        Spacer(Modifier.height(20.dp))
        // Animación especial para el número de respuesta
        val infiniteTransition = rememberInfiniteTransition()
        val pulseScale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            visible = visible,
            enter = scaleIn(animationSpec = spring(dampingRatio = 0.5f)) + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            Text(
                "${lista_numeros.sum()}",
                fontSize = 120.sp,
                modifier = Modifier
                    .scale(pulseScale),
                fontFamily = KanitFontFamily,
                color = Amarrillo
            )
        }
        if(esAcierto){
            SoundManager.reproducirAplausos()
            userViewModel.actualizarEstadisticas(true)
            Text(
                "¡Acertaste!",
                style = MaterialTheme.typography.headlineSmall,
                fontFamily = KanitFontFamily)
        } else {
            SoundManager.reproducirIncorrecto()
            userViewModel.actualizarEstadisticas(false)
            Text(
                "¡Fallaste!. Inténtalo de nuevo",
                style = MaterialTheme.typography.headlineSmall,
                fontFamily = KanitFontFamily)
        }
        Spacer(Modifier.height(10.dp))
        Text(
            "     Tu respuesta fue: $respuestaUsuario",
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = KanitFontFamily)
        Spacer(Modifier.height(20.dp))
        val chunkedNumbers = lista_numeros.chunked(3)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ){
            chunkedNumbers.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    row.forEach { num ->
                        Text(
                            num.toString(),
                            style = MaterialTheme.typography.headlineSmall,
                            fontFamily = KanitFontFamily,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    repeat(3 - row.size){
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate("game")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ){
            Text(
                "Volver a jugar",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily
            )
        }
        Button(
            onClick = {
                navController.navigate("levels")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ){
            Text(
                "Ir a dificultades",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily)
        }
        Spacer(Modifier.height(30.dp))
    }
}