package co.edu.upb.numerosflash.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import co.edu.upb.numerosflash.R

object SoundManager {
    private lateinit var soundPool: SoundPool
    private var soundAplausos: Int = 0
    private var soundIncorrecto: Int = 0
    private var initialized = false

    fun initSoundPool(context: Context){
        if(initialized) return

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()
        soundAplausos = soundPool.load(context, R.raw.applause, 1)
        soundIncorrecto = soundPool.load(context, R.raw.fail, 1)
    }

    fun reproducirAplausos(){
        soundPool.play(soundAplausos, 1f, 1f, 0, 0, 1f)
    }

    fun reproducirIncorrecto(){
        soundPool.play(soundIncorrecto, 1f, 1f, 0, 0, 1f)
    }
    fun release(){
        if(initialized){
            soundPool.release()
            initialized = false
        }
    }
}