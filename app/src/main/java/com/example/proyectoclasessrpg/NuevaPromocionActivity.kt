package com.example.proyectoclasessrpg

import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPromocionBinding

class NuevaPromocionActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaPromocionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Añadir una promoción de clase"
    }
}