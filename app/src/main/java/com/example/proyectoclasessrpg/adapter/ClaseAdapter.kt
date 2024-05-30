package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.ProyectoSrpg
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Clase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClaseAdapter(private val claseList:List<Clase>): RecyclerView.Adapter<ClaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ClaseViewHolder(layoutInflater.inflate(R.layout.item_clase,parent,false))
    }

    override fun onBindViewHolder(holder: ClaseViewHolder, position: Int) {
        val item = claseList[position]
        holder.render(item)

        holder.itemView.setOnLongClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                ProyectoSrpg.database.listaCla().deleteClase(item)
            }
            true
        }
    }

    override fun getItemCount(): Int = claseList.size
}