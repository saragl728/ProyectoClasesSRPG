package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Habilidad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabilidadAdapter(private val habilidadList:List<Habilidad>): RecyclerView.Adapter<HabilidadViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabilidadViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return HabilidadViewHolder(layoutInflater.inflate(R.layout.item_habilidad,parent,false))
    }

    override fun getItemCount(): Int = habilidadList.size

    override fun onBindViewHolder(holder: HabilidadViewHolder, position: Int) {
        val item = habilidadList[position]
        holder.render(item)

    }

}