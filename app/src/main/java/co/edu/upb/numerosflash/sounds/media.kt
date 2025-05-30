package co.edu.upb.numerosflash.sounds

import android.content.Context
import android.media.MediaPlayer

object MusicManager{
    private var mediaPlayer: MediaPlayer? = null
    private var initialized = false
    private var currentResId: Int? = null

    fun play(context: Context, resId: Int, loop: Boolean = true) {
        if (mediaPlayer != null && currentResId == resId && mediaPlayer!!.isPlaying) {
            return
        }
        stop()

        mediaPlayer = MediaPlayer.create(context, resId).apply {
            isLooping = loop
            setVolume(0.5f, 0.5f)
            start()
        }
        currentResId = resId
    }
    fun pause(){
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        }
    }
    fun stop(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        currentResId = null
    }
}