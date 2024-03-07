package com.example.proyectoclasessrpg

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.HabilidadAdapter
import com.example.proyectoclasessrpg.databinding.ActivityListadoHabilidadesBinding

class ListadoHabilidadesActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoHabilidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Lista de habilidades"

        binding.recycler.layoutManager = LinearLayoutManager(this)

        var adapter = HabilidadAdapter(HabilidadProvider.listaHabilidades)
        binding.recycler.adapter = adapter

    }
}