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

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deletePropiedad(Propiedad(propiedadModel.nombrePropiedad))
                    }

                })

            true
        }
    }
}