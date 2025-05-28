package co.edu.upb.numerosflash.views

import android.graphics.drawable.Drawable
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import co.edu.upb.numerosflash.layouts.sideMenu

@Composable
fun Home(navController: NavController){
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
        ){
            Header(navController, scope, drawerState)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Inicio",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(30.dp))
            Column (
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {navController.navigate("Levels")},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Jugar", style = MaterialTheme.typography.bodyLarge)
                }
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {navController.navigate("multiplayer")},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Multijugador", style = MaterialTheme.typography.bodyLarge)
                }
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {navController.navigate("instructions")},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Instrucciones", style = MaterialTheme.typography.bodyLarge)
                }
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {navController.navigate("tips")},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Trucos", style = MaterialTheme.typography.bodyLarge)
                }
                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = {navController.navigate("profile")},
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Perfil", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}