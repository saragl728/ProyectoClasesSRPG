package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityListadoPromocionesBinding

class ListadoPromocionesActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoPromocionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de promociones"

        binding.recycler.layoutManager = LinearLayoutManager(this)

        //para buscar clases que promocionan a la que se busca
        binding.bPromoA.setOnClickListener {
            //se comprueba si el texto de búsqueda no está en blanco
            if (binding.filtro.text.toString().isNotEmpty()){

            }
            else{
                Toast.makeText(this, "No hay nada que buscar", Toast.LENGTH_LONG).show()
            }
        }

        //para buscar clases que promocionan de la que se busca
        binding.bPromoDe.setOnClickListener {
            //se comprueba si el texto de búsqueda no está en blanco
            if (binding.filtro.text.toString().isNotEmpty()){

            }
            else{
                Toast.makeText(this, "No hay nada que buscar", Toast.LENGTH_LONG).show()
            }
        }
    }
}