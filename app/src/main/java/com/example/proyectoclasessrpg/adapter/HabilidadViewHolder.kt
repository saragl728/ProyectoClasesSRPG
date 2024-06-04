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

        binding.bEliminar.setOnClickListener {
            var aviso = AlertDialog.Builder(this.itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres eliminar la habilidad ${habilidadModel.nombreHabilidad}?")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().borraHabilidad(Habilidad(habilidadModel.nombreHabilidad, habilidadModel.descripcion))
            }
                })
                .setNegativeButton(android.R.string.cancel, null)
            aviso.show()
        }
    }
}