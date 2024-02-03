package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPropiedadBinding

class NuevaPropiedadActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaPropiedadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir propiedad"

        binding.bAnyadirPropiedad.setOnClickListener {
            if (binding.textoPropiedad.text.toString().isNotEmpty()){

            }
            else{
                Toast.makeText(this, "El nombre de la propiedad no puede estar en blanco", Toast.LENGTH_LONG).show()
            }
        }
    }
}