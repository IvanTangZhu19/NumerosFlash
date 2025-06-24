package co.edu.upb.numerosflash.views

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.numerosflash.R
import androidx.compose.material3.AlertDialog
import co.edu.upb.numerosflash.firebase.AuthManager
import co.edu.upb.numerosflash.ui.theme.Amarrillo
import co.edu.upb.numerosflash.ui.theme.KanitFontFamily

@Composable
fun Register(navController: NavController){
    var email by remember{ mutableStateOf("") }
    var usuario by remember{ mutableStateOf("") }
    var contraseña by remember{ mutableStateOf("") }
    var contraseñaVisible by remember { mutableStateOf(false) }

    var errorMessage by remember { mutableStateOf<String?>(null) }
    var showErrorDialog by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

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
            "NúmerosFlash",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Amarrillo,
            fontFamily = KanitFontFamily
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Recuerda, calcula... ¡y gana en un flash!",
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic,
            fontFamily = KanitFontFamily
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo",
                fontFamily = KanitFontFamily) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {Icon(Icons.Default.Email, contentDescription = "correo")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario",
                fontFamily = KanitFontFamily) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {Icon(Icons.Filled.Person, contentDescription = "usuario")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = {Text("Contraseña",
                fontFamily = KanitFontFamily)},
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
            onClick = {
                if (usuario.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {
                    errorMessage = "Por favor, completa todos los campos"
                    showErrorDialog = true
                    return@Button
                }

                errorMessage = null
                AuthManager.register(
                    email = email,
                    password = contraseña,
                    username = usuario,
                    onSuccess = { user ->
                        isLoading = false
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    onError = { error ->
                        isLoading = false
                        errorMessage = when (error) {
                            "The email address is badly formatted." -> "El formato del correo electrónico no es válido"
                            "The password must be 6 characters long or more." -> "La contraseña debe tener al menos 6 caracteres"
                            "The email address is already in use by another account." -> "Este correo electrónico ya está registrado"
                            else -> "Error al registrar: $error"
                        }
                        showErrorDialog = true
                    }
                )
            },
            modifier = Modifier.width(170.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "Registrarse",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = KanitFontFamily)
        }
    }
    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = { Text("Error",
                fontFamily = KanitFontFamily) },
            text = { Text(errorMessage ?: "Ha ocurrido un error",
                fontFamily = KanitFontFamily) },
            confirmButton = {
                TextButton(onClick = { showErrorDialog = false }) {
                    Text("Aceptar",
                        fontFamily = KanitFontFamily)
                }
            }
        )
    }
}