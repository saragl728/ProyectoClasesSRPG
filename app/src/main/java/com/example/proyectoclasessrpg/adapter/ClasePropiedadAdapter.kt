package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClasePropiedad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasePropiedadAdapter(private val clasePropiedadList: List<ClasePropiedad>): RecyclerView.Adapter<ClasePropiedadViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasePropiedadViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ClasePropiedadViewHolder(layoutInflater.inflate(R.layout.item_clase_propiedad,parent,false))
    }

    override fun getItemCount(): Int = clasePropiedadList.size

    override fun onBindViewHolder(holder: ClasePropiedadViewHolder, position: Int) {
        val item = clasePropiedadList[position]
        holder.render(item)

    }

}