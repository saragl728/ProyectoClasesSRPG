package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Propiedad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PropiedadAdapter(private val propiedadList:List<Propiedad>): RecyclerView.Adapter<PropiedadViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropiedadViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PropiedadViewHolder(layoutInflater.inflate(R.layout.item_propiedad, parent, false))
    }

    override fun getItemCount(): Int = propiedadList.size

    override fun onBindViewHolder(holder: PropiedadViewHolder, position: Int) {
        val item = propiedadList[position]
        holder.render(item)

    }
}