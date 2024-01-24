package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityNuevaArmaBinding

class NuevaArmaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaArmaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}