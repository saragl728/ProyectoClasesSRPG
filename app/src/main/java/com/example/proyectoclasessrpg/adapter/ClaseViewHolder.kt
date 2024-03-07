package com.example.proyectoclasessrpg.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.databinding.ItemClaseBinding

class ClaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemClaseBinding.bind(view)
    fun render(claseModel: Clase){
        binding.nombreInternoClase.text = claseModel.nombreInterno
        binding.nombreVisibleClase.text = claseModel.nombre
        binding.descripcionClase.text = claseModel.descripcion
        binding.movimientoClase.text = claseModel.movimiento.toString()
    }
}