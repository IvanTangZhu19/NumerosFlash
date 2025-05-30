package co.edu.upb.numerosflash.models

data class User(
    val usuario: String = "",
    val correo: String = "",
    val partidasJugadas: Int = 0,
    val partidasGanadas: Int = 0
)
