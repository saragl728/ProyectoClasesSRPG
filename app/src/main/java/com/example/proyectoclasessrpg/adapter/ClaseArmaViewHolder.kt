package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClaseArma
import com.example.proyectoclasessrpg.databinding.ItemClaseArmaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseArmaViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var binding = ItemClaseArmaBinding.bind(view)
    fun render(claseArmaModel: ClaseArma){
        binding.nombreClase.text = claseArmaModel.nomClase
        binding.nombreArma.text = claseArmaModel.nomArma

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deleteClaseConArma(ClaseArma(claseArmaModel.nomClase, claseArmaModel.nomArma))
                    }

                })

            true
        }
    }
}