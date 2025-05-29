package co.edu.upb.numerosflash.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.models.Level
import co.edu.upb.numerosflash.ui.theme.DarkBlue
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily
import co.edu.upb.numerosflash.ui.theme.Vhite

@Composable
fun LevelItem(
    titulo: String,
    descripcion: String,
    navController: NavController,
    niveles: List<Level>,
    onLevelSelected: (Level) -> Unit
){
    var showDialog by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            titulo,
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = KanitFontFamily
        )
        IconButton(
            onClick = { showDialog = true },
        ) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                modifier = Modifier.size(44.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ){
        niveles.forEach { nivel ->
            Button(
                onClick = {onLevelSelected(nivel)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Vhite
                )
            ) {
                Text(
                    "${nivel.id}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = KanitFontFamily
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(18.dp))
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(titulo,
                fontFamily = KanitFontFamily) },
            text = { Text(descripcion,
                fontFamily = KanitFontFamily) },
            confirmButton = {
                TextButton(onClick={ showDialog = false }) { Text("Cerrar",
                    fontFamily = KanitFontFamily)}
            }
        )
    }
}