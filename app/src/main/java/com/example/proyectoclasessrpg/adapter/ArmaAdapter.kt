package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Arma

class ArmaAdapter(private val armaList:List<Arma>): RecyclerView.Adapter<ArmaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmaViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ArmaViewHolder(layoutInflater.inflate(R.layout.item_arma,parent,false))
    }

    override fun onBindViewHolder(holder: ArmaViewHolder, position: Int) {
        val item = armaList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = armaList.size

}