package co.edu.upb.numerosflash.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import co.edu.upb.numerosflash.layouts.Header
import co.edu.upb.numerosflash.layouts.sideMenu
import co.edu.upb.numerosflash.viewmodels.Game

@Composable
fun Game(navController: NavController, gameViewModel: Game){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var num by remember{ mutableStateOf(TextFieldValue("")) }
    val nivel = gameViewModel.nivel.collectAsState().value

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
            Box(Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center){
                Text(text="Numero", fontSize = 70.sp)
            }
            Text("Escribe la respuesta: ", style = MaterialTheme.typography.bodyLarge)
            TextField(
                value = num,
                onValueChange = { num = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Button(
                onClick = {

                }
            ){
                Text("Validar", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}