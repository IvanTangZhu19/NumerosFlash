package co.edu.upb.numerosflash.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun sideMenu(navController: NavController){
    ModalDrawerSheet(
        modifier = Modifier.width(200.dp)
    ) {
        Text("Menu", modifier = Modifier.padding(16.dp))
        NavigationDrawerItem(
            label = {Text("Inicio")},
            selected = false,
            onClick = {navController.navigate("home")}
        )
        NavigationDrawerItem(
            label = {Text("Instrucciones")},
            selected = false,
            onClick = {navController.navigate("instructions")}
        )
        NavigationDrawerItem(
            label = {Text("Trucos")},
            selected = false,
            onClick = {navController.navigate("instructions")}
        )
        NavigationDrawerItem(
            label = {Text("Perfil")},
            selected = false,
            onClick = {navController.navigate("profile")}
        )
    }
}