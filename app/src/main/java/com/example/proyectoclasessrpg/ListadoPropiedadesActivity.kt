package com.example.proyectoclasessrpg

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityListadoPropiedadesBinding

class ListadoPropiedadesActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoPropiedadesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de propiedades"

        binding.recycler.layoutManager = LinearLayoutManager(this)
    }
}