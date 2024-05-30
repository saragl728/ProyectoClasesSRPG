package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.proyectoclasessrpg.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition{true}

        //pausa de 3 segundos
        Thread.sleep(3000)

        //pasa a la actividad principal
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}