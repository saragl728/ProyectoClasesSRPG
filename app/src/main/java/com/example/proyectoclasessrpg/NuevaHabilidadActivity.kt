package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaHabilidadBinding

class NuevaHabilidadActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaHabilidadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir habilidad"

        //si se intenta añadir una habilidad
        binding.bAnyadirHabilidad.setOnClickListener {
            //se comprueba si se han rellenado los campos
            if (binding.nombre.text.toString().isNotEmpty() && binding.descripcion.text.toString().isNotEmpty()){

            }
            else{
                //si alguno está vacío, se avisa
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}