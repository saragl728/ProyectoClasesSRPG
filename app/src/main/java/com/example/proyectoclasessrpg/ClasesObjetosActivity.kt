package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ClaseArmaAdapter
import com.example.proyectoclasessrpg.adapter.ClaseHabilidadAdapter
import com.example.proyectoclasessrpg.adapter.ClasePropiedadAdapter
import com.example.proyectoclasessrpg.database.ClaseArma
import com.example.proyectoclasessrpg.database.ClaseHabilidad
import com.example.proyectoclasessrpg.database.ClasePropiedad
import com.example.proyectoclasessrpg.databinding.ActivityClasesObjetosBinding
import com.example.proyectoclasessrpg.provider.ClaseArmaProvider
import com.example.proyectoclasessrpg.provider.ClaseHabilidadProvider
import com.example.proyectoclasessrpg.provider.ClasePropiedadProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasesObjetosActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityClasesObjetosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.layoutManager = LinearLayoutManager(this)

        //botón para buscar clases según el tipo de objeto con las que están relacionadas
        binding.boton.setOnClickListener {
            try {
                //comprobación del filtro
                var filtro = Estatico.FormatSimple(binding.tFiltro.editText?.text.toString(), "Hay que introducir algo que buscar")

                if (binding.radioPropiedad.isChecked){
                    var adapter = ClasePropiedadAdapter(ClasePropiedadProvider.listaClasePropiedad)
                    binding.recycler.adapter = adapter

                    CoroutineScope(Dispatchers.IO).launch {
                    //var objetos : List<ClasePropiedad> = ProyectoSrpg.database.listaCla().getClasePorPropiedad(filtro)
                        var objetos : List<ClasePropiedad> = auxDao.getClasePorPropiedad(filtro)
                        adapter = ClasePropiedadAdapter(objetos)

                }
                runOnUiThread { true }

                }
                if (binding.radioArma.isChecked){
                    var adapter = ClaseArmaAdapter(ClaseArmaProvider.listaClaseArma)
                    binding.recycler.adapter = adapter
                    CoroutineScope(Dispatchers.IO).launch {
                        //var objetos : List<ClaseArma> = ProyectoSrpg.database.listaCla().getClasePorArma(filtro)
                        var objetos : List<ClaseArma> = auxDao.getClasePorArma(filtro)
                        adapter = ClaseArmaAdapter(objetos)
                    }
                    runOnUiThread { true }

                }
                if (binding.radioHabilidad.isChecked){
                    var adapter = ClaseHabilidadAdapter(ClaseHabilidadProvider.listaClaseHabilidad)
                    binding.recycler.adapter = adapter

                    CoroutineScope(Dispatchers.IO).launch {
                        //var objetos : List<ClaseHabilidad> = ProyectoSrpg.database.listaCla().getClasePorHabilidad(filtro)
                        var objetos : List<ClaseHabilidad> = auxDao.getClasePorHabilidad(filtro)
                        adapter = ClaseHabilidadAdapter(objetos)
                    }
                    runOnUiThread { true }
                }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }


        binding.bMas.setOnClickListener {
            actividadActual = 10
            startActivity(Intent(this, ConectarClasesOtrosActivity::class.java))
        }

    }
}