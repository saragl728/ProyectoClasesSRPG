package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonRegistro.setOnClickListener {

        }
    }
}