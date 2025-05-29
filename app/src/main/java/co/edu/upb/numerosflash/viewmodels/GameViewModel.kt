package co.edu.upb.numerosflash.viewmodels

import androidx.lifecycle.ViewModel
import co.edu.upb.numerosflash.models.Level
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel: ViewModel(){
    private val _nivel = MutableStateFlow<Level?>(null)
    val nivel: StateFlow<Level?> = _nivel

    fun seleccionarNivel(nivel: Level){
        _nivel.value = nivel
    }
}