package com.example.proyectoclasessrpg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.R
import com.example.proyectoclasessrpg.database.Promocion

class PromocionAdapter(private val promocionList: List<Promocion>): RecyclerView.Adapter<PromocionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromocionViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PromocionViewHolder(layoutInflater.inflate(R.layout.item_promocion,parent,false))
    }

    override fun onBindViewHolder(holder: PromocionViewHolder, position: Int) {
        val item = promocionList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = promocionList.size

}