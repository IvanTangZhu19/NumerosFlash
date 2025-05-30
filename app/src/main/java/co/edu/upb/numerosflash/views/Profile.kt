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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.sideMenu
import co.edu.upb.numerosflash.ui.theme.DarkBlue
import co.edu.upb.numerosflash.ui.theme.Vhite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import co.edu.upb.numerosflash.firebase.AuthManager
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily
import co.edu.upb.numerosflash.viewmodels.UserViewModel

@Composable
fun Profile(navController: NavController, viewModel: UserViewModel){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var showLogoutDialog by remember { mutableStateOf(false) }
    val username = AuthManager.getUsername()

    LaunchedEffect(Unit) {
        viewModel.getUser()
    }
    val usuario = viewModel.usuario.value

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Cerrar sesión",
                fontFamily = KanitFontFamily) },
            text = { Text("¿Estás seguro de que quieres cerrar sesión?",
                fontFamily = KanitFontFamily) },
            confirmButton = {
                TextButton(
                    onClick = {
                        AuthManager.signOut()
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                ) {
                    Text("Sí, cerrar sesión",
                        fontFamily = KanitFontFamily)
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
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
                    "Perfil",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Center),
                    fontFamily = KanitFontFamily
                )
            }
            if (usuario != null) {
                Text(
                    "Nombre: ${usuario.usuario}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    "Correo: ${usuario.correo}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )
                Spacer(Modifier.height(30.dp))
                Text(
                    "Partidas jugadas: ${usuario.partidasJugadas}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    "Partidas ganadas: ${usuario.partidasGanadas}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )
                Spacer(Modifier.height(15.dp))
                /*Text(
                    "Porcentaje de partidas ganadas: ${usuario.partidasGanadas / usuario.partidasJugadas } %",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )*/
            }
            /*Text(
                "Nombre por auth: ${username}",
                style = MaterialTheme.typography.headlineSmall,
                fontFamily = KanitFontFamily
            )*/
            Button(
                onClick = {
                    showLogoutDialog = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Vhite
                )
            ) {
                Text(
                    "Cerrar sesión",
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = KanitFontFamily
                )
            }
        }
    }
}