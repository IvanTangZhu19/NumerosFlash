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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        "\uD83D\uDC22 Calentamiento ",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    IconButton(
                        onClick = {  },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ){
                    Button(
                        onClick = {  },
                    ){
                        Text("1", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("2", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("3", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("4", style = MaterialTheme.typography.headlineSmall)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        "\uD83C\uDFC3\u200D♂\uFE0F Desafío Rápido ",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    IconButton(
                        onClick = {  },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ){
                    Button(
                        onClick = {  },
                    ){
                        Text("1", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("2", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("3", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("4", style = MaterialTheme.typography.headlineSmall)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        " \uD83C\uDF29\uFE0F Relámpago",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    IconButton(
                        onClick = {  },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ){
                    Button(
                        onClick = {  },
                    ){
                        Text("1", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("2", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("3", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("4", style = MaterialTheme.typography.headlineSmall)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        "⚡\uFE0F Flash",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    IconButton(
                        onClick = {  },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ){
                    Button(
                        onClick = {  },
                    ){
                        Text("1", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("2", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("3", style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = {  },
                    ){
                        Text("4", style = MaterialTheme.typography.headlineSmall)
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