package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClaseHabilidad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseHabilidadAdapter(private val claseHabilidadList: List<ClaseHabilidad>): RecyclerView.Adapter<ClaseHabilidadViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseHabilidadViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ClaseHabilidadViewHolder(layoutInflater.inflate(R.layout.item_clase_habilidad,parent,false))
    }

    override fun getItemCount(): Int = claseHabilidadList.size

    override fun onBindViewHolder(holder: ClaseHabilidadViewHolder, position: Int) {
        val item = claseHabilidadList[position]
        holder.render(item)

    }
}
