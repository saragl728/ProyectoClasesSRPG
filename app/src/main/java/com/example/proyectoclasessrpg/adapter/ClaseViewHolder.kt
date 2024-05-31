package com.example.proyectoclasessrpg.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.databinding.ItemClaseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemClaseBinding.bind(view)
    fun render(claseModel: Clase){
        binding.nombreInternoClase.text = claseModel.nombreInterno
        binding.nombreVisibleClase.text = claseModel.nombre
        binding.descripcionClase.text = claseModel.descripcion
        binding.movimientoClase.text = claseModel.movimiento.toString()

        binding.bEliminar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().borraClase(Clase(claseModel.nombreInterno, claseModel.nombre, claseModel.descripcion, claseModel.movimiento))
            }
        }
    }
}