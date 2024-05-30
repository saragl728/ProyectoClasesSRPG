package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClasePropiedad
import com.example.proyectoclasessrpg.databinding.ItemClasePropiedadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasePropiedadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding = ItemClasePropiedadBinding.bind(view)

    fun render(clasePropiedadModel: ClasePropiedad){
        binding.nombreClase.text = clasePropiedadModel.Clase
        binding.nombrePropiedad.text = clasePropiedadModel.Propiedad

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deleteClaseConPropiedad(ClasePropiedad(clasePropiedadModel.Clase, clasePropiedadModel.Propiedad))
                    }

                })

            true
        }
    }
}