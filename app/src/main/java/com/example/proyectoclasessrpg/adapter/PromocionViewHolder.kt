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

        itemView.setOnLongClickListener {
            var aviso = AlertDialog.Builder(itemView.context)
            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.warning)
            aviso.setMessage("¿Seguro que quieres eliminar este elemento?")

                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    CoroutineScope(Dispatchers.IO).launch {
                        ProyectoSrpg.database.listaCla().deletePromocion(Promocion(promocionModel.claseBase, promocionModel.clasePromocionada))
                    }

                })

            true
        }
    }

}