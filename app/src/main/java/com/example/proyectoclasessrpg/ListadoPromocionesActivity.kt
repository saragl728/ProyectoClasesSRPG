package com.example.proyectoclasessrpg

import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityListadoPromocionesBinding

class ListadoPromocionesActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoPromocionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de promociones"
    }
}