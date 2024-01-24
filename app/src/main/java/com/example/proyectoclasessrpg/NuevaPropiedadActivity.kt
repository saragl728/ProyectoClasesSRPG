package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPropiedadBinding

class NuevaPropiedadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaPropiedadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}