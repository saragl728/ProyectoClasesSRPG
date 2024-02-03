package com.example.proyectoclasessrpg

import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityListadoArmasBinding

class ListadoArmasActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoArmasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de tipos de armas"
    }
}