package co.edu.upb.numerosflash.views

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.R
import co.edu.upb.numerosflash.ui.theme.DarkBlue
import co.edu.upb.numerosflash.ui.theme.Vhite

@Composable
fun Home(navController: NavController){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Column (
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "NumerosFlash",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Recuerda, calcula... ¡y gana en un flash!",
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {navController.navigate("Levels")},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ) {
            Text("Jugar", style = MaterialTheme.typography.bodyLarge)
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {navController.navigate("multiplayer")},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ) {
            Text("Multijugador", style = MaterialTheme.typography.bodyLarge)
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {navController.navigate("instructions")},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ) {
            Text("Instrucciones", style = MaterialTheme.typography.bodyLarge)
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {navController.navigate("tips")},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ) {
            Text("Trucos", style = MaterialTheme.typography.bodyLarge)
        }
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {navController.navigate("profile")},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = Vhite
            )
        ) {
            Text("Perfil", style = MaterialTheme.typography.bodyLarge)
        }
    }
    /*ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            sideMenu(navController)
        },
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
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

            }
        }
    }*/
}