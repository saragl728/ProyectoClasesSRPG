package com.example.proyectoclasessrpg.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.database.Propiedad
import com.example.proyectoclasessrpg.databinding.ItemPropiedadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PropiedadViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    val binding = ItemPropiedadBinding.bind(view)

    fun render(propiedadModel: Propiedad){
        binding.nombrePropiedad.text = propiedadModel.nombrePropiedad

        binding.bEliminar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().borraPropiedad(Propiedad(propiedadModel.nombrePropiedad))
            }
        }
    }
}