package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.HabilidadAdapter
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.databinding.ActivityListadoHabilidadesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoHabilidadesActivity : ActividadConMenus() {

    lateinit var listaObjetos :List<Habilidad>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoHabilidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Lista de habilidades"

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoHabilidadesActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = HabilidadAdapter(auxDao.getAllHabilidades())
            }
            runOnUiThread { true }
        }

        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomHabilidad.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getHabilidadPorNombre(filtro)
                }
                runOnUiThread {
                    binding.recycler.apply {
                        adapter = HabilidadAdapter(listaObjetos)
                    }
                }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        binding.bMas.setOnClickListener {
            actividadActual = 5
            startActivity(Intent(this, NuevaHabilidadActivity::class.java))
        }

    }
}