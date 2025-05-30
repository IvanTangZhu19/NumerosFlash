package co.edu.upb.numerosflash.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import co.edu.upb.numerosflash.firebase.AuthManager
import co.edu.upb.numerosflash.models.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.compose.runtime.State
import com.google.firebase.firestore.FieldValue

class UserViewModel : ViewModel() {

    private val _usuario = mutableStateOf<User?>(null)
    val usuario: State<User?> = _usuario

    fun getUser(){
        val db: FirebaseFirestore = Firebase.firestore
        val userID = AuthManager.getCurrentUser()?.uid
        if (userID == null) {
            Log.w("UserViewModel", "Usuario no autenticado")
            return
        }
        val docRef = db.collection("USERS").document(userID)

        docRef.get().addOnSuccessListener { document ->
            if (document.exists()) {
                val NombreUsuario = document.getString("usuario") ?: ""
                val correo = document.getString("correo") ?: ""
                val partidasGanadas = document.getLong("partidasGanadas")?.toInt() ?: 0
                val partidasJugadas = document.getLong("partidasJugadas")?.toInt() ?: 0
                _usuario.value = User(NombreUsuario, correo, partidasJugadas, partidasGanadas)
            }
        }.addOnFailureListener { exception ->
            Log.e("UserViewModel", "Error al obtener usuario", exception)
        }
    }
    fun actualizarEstadisticas(gano: Boolean) {
        val db = Firebase.firestore
        val userID = AuthManager.getCurrentUser()?.uid
        if (userID == null) {
            Log.w("UserViewModel", "Usuario no autenticado")
            return
        }
        var actualizaciones: Map<String, Any>

        val docRef = db.collection("USERS").document(userID)
        if (gano){
            actualizaciones = mapOf(
                "partidasGanadas" to FieldValue.increment(1),
                "partidasJugadas" to FieldValue.increment(1)
            )
        } else {
            actualizaciones = mapOf(
                "partidasGanadas" to FieldValue.increment(0),
                "partidasJugadas" to FieldValue.increment(1)
            )
        }


        docRef.update(actualizaciones)
            .addOnSuccessListener {
                Log.d("UserViewModel", "Estadísticas actualizadas: $actualizaciones")
            }
            .addOnFailureListener { e ->
                Log.e("UserViewModel", "Error al actualizar estadísticas", e)
            }
    }
}