package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Promocion
import com.example.proyectoclasessrpg.databinding.ItemPromocionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PromocionViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var binding = ItemPromocionBinding.bind(view)

    fun render(promocionModel: Promocion){
        binding.claseInicial.text = promocionModel.claseBase
        binding.claseAvanzada.text = promocionModel.clasePromocionada

        binding.bEliminar.setOnClickListener {
            var aviso = AlertDialog.Builder(this.itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres eliminar esta promoción?(${promocionModel.claseBase} -> ${promocionModel.clasePromocionada})")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().deletePromocion(Promocion(promocionModel.claseBase, promocionModel.clasePromocionada))
            }
                })
                .setNegativeButton(android.R.string.cancel, null)
            aviso.show()
        }
    }

}