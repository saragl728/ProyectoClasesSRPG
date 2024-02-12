package com.example.proyectoclasessrpg

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityListadoClasesBinding

class ListadoClasesActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoClasesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de clases"

        binding.recycler.layoutManager = LinearLayoutManager(this)
    }
}