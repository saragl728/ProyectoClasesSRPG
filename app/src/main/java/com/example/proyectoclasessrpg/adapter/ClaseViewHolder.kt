package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
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

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deleteClase(Clase(claseModel.nombreInterno, claseModel.nombre, claseModel.descripcion, claseModel.movimiento))
                        
                    }

                })

            true
        }
    }
}