package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
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
            var aviso = AlertDialog.Builder(this.itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres eliminar la propiedad ${propiedadModel.nombrePropiedad}?")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().borraPropiedad(Propiedad(propiedadModel.nombrePropiedad))
            }
                })
                .setNegativeButton(android.R.string.cancel, null)
            aviso.show()
        }
    }
}