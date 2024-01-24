package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityListadoArmasBinding

class ListadoArmasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoArmasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}