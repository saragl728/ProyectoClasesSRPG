package com.example.proyectoclasessrpg.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
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
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().deletePromocion(Promocion(promocionModel.claseBase, promocionModel.clasePromocionada))
            }

        }

    }

}