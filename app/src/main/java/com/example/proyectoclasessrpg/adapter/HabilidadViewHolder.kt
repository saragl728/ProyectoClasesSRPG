package com.example.proyectoclasessrpg.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.databinding.ItemHabilidadBinding

class HabilidadViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemHabilidadBinding.bind(view)

    fun render(habilidadModel: Habilidad){
        binding.nombreHabilidad.text = habilidadModel.nombreHabilidad
        binding.descripcionHabilidad.text = habilidadModel.descripcion
    }
}