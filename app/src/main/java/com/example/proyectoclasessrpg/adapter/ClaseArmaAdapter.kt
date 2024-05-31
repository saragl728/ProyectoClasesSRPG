package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.ClaseArma
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseArmaAdapter(private val claseArmaList: List<ClaseArma>): RecyclerView.Adapter<ClaseArmaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseArmaViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ClaseArmaViewHolder(layoutInflater.inflate(R.layout.item_clase_arma,parent,false))
    }

    override fun getItemCount(): Int = claseArmaList.size

    override fun onBindViewHolder(holder: ClaseArmaViewHolder, position: Int) {
        val item = claseArmaList[position]
        holder.render(item)

    }
}