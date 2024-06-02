package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClaseHabilidad
import com.example.proyectoclasessrpg.databinding.ItemClaseHabilidadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseHabilidadViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var binding = ItemClaseHabilidadBinding.bind(view)

    fun render(claseHabilidadModel: ClaseHabilidad){
        binding.nombreClase.text = claseHabilidadModel.Clase
        binding.nombreHabilidad.text = claseHabilidadModel.Habilidad

        binding.bEliminar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().deleteClaseConHabilidad(ClaseHabilidad(claseHabilidadModel.Clase, claseHabilidadModel.Habilidad))
            }
        }
    }
}