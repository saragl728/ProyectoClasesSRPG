package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaArmaBinding

class NuevaArmaActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaArmaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir tipo de arma"

        binding.bAnyadirArma.setOnClickListener {
            if (binding.nuevaArma.text.isNotEmpty()){

            }
            else{
                Toast.makeText(this, "El tipo de arma no se puede dejar en blanco", Toast.LENGTH_LONG).show()
            }
        }
    }
}