package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityClasesObjetosBinding

class ClasesObjetosActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityClasesObjetosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)

        //botón para buscar clases según el tipo de objeto con las que están relacionadas
        binding.boton.setOnClickListener {
            //se comprueba que el filtro no está vacío
            if (binding.filtro.text.toString().isNotEmpty()){
                if (binding.radioPropiedad.isChecked){

                }
                if (binding.radioArma.isChecked){

                }
                if (binding.radioHabilidad.isChecked){

                }
            }
            //si no hay nada en el filtro, dirá un mensaje diciendo que no se puede buscar nada
            else{
                Toast.makeText(this, "Hay que escribir algo que buscar", Toast.LENGTH_LONG).show()
            }
        }
    }
}