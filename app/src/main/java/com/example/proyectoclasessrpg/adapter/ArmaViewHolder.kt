package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Arma
import com.example.proyectoclasessrpg.databinding.ItemArmaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArmaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding = ItemArmaBinding.bind(view)

    fun render(armaModel: Arma){
        binding.nombreArma.text = armaModel.NombreArma

        binding.bEliminar.setOnClickListener {
            var aviso = AlertDialog.Builder(this.itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres eliminar el tipo de arma ${armaModel.NombreArma}?")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().borraArma(Arma(armaModel.NombreArma))
            }
                })
                .setNegativeButton(android.R.string.cancel, null)
            aviso.show()
        }
    }
}