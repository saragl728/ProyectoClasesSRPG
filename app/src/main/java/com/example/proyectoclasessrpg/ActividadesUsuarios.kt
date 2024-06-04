package com.example.proyectoclasessrpg

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class ActividadesUsuarios: AppCompatActivity() {

    lateinit var sonidoInicio: MediaPlayer
    lateinit var sonidoError: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sonidoInicio = MediaPlayer.create(this, R.raw.windowsxpstartup)
        sonidoError = MediaPlayer.create(this, R.raw.windowsxperror)
    }

    fun InicioSesion(){
        sonidoInicio.start()
        val intent = Intent(this, ListadoClasesActivity::class.java)
        startActivity(intent)
    }

}