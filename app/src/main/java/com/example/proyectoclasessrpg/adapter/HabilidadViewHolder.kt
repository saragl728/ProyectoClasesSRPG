package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.databinding.ItemHabilidadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabilidadViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemHabilidadBinding.bind(view)

    fun render(habilidadModel: Habilidad){
        binding.nombreHabilidad.text = habilidadModel.nombreHabilidad
        binding.descripcionHabilidad.text = habilidadModel.descripcion

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deleteHabilidad(Habilidad(habilidadModel.nombreHabilidad, habilidadModel.descripcion))
                    }

                })

            true
        }
    }
}