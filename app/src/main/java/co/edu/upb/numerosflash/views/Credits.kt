package co.edu.upb.numerosflash.views

import android.R.attr.navigationIcon
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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.sideMenu
import co.edu.upb.numerosflash.ui.theme.Amarrillo
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily

@Composable
fun Credits(navController: NavController){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            sideMenu(navController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
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
                    "Créditos",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Center),
                    fontFamily = KanitFontFamily
                )
            }
            val infiniteTransition = rememberInfiniteTransition()
            val pulseScale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1.1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Desarrollador",
                modifier = Modifier.size(48.dp),
                tint= Amarrillo
            )
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedVisibility(
                visible = true,
                enter = scaleIn(animationSpec = spring(dampingRatio = 0.5f)) + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                Text(
                    "Desarrollado por",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily,
                    color = Amarrillo,
                    modifier = Modifier
                        .scale(pulseScale),
                )
            }
            Text(
                "Iván Tang Zhu",
                style = MaterialTheme.typography.headlineSmall,
                fontFamily = KanitFontFamily,
                color = Amarrillo,
                modifier = Modifier
                    .scale(pulseScale)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Diseño UI/UX • Programación • Testing",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(30.dp))
            Text(
                "¡Gracias por jugar!",
                style = MaterialTheme.typography.headlineSmall,
                fontFamily = KanitFontFamily,
                color = Amarrillo
            )
            Spacer(Modifier.height(20.dp))
            Text(
                "Versión 2.0",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily,
            )
            Spacer(Modifier.height(20.dp))
            Text(
                "Desarrollado en 2025 para el curso: Aplicaciones móviles",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily,
            )
        }
    }
}