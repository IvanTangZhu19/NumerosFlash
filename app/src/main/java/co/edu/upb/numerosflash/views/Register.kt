package co.edu.upb.numerosflash.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.R

@Composable
fun Register(navController: NavController){
    var email by remember{ mutableStateOf("") }
    var usuario by remember{ mutableStateOf("") }
    var contraseña by remember{ mutableStateOf("") }
    var contraseñaVisible by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "NumerosFlash",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Recuerda, calcula... ¡y gana en un flash!",
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {Icon(Icons.Default.Email, contentDescription = "correo")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {Icon(Icons.Filled.Person, contentDescription = "usuario")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = {Text("Contraseña")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {Icon(Icons.Default.Lock, contentDescription = "contraseña")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (contraseñaVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if(contraseñaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(
                    onClick = {
                        contraseñaVisible = !contraseñaVisible
                    }
                ) {
                    Icon(imageVector = image, contentDescription = "ver contraseña")
                }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.width(170.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Registrarse", style = MaterialTheme.typography.bodyLarge)
        }
    }

}