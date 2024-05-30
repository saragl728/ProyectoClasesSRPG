package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.HabilidadAdapter
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.databinding.ActivityListadoHabilidadesBinding
import com.example.proyectoclasessrpg.provider.HabilidadProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoHabilidadesActivity : ActividadConMenus() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoHabilidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Lista de habilidades"

        binding.recycler.layoutManager = LinearLayoutManager(this)

        var adapter = HabilidadAdapter(HabilidadProvider.listaHabilidades)
        binding.recycler.adapter = adapter


        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomHabilidad.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    //var objetos : List<Habilidad> = ProyectoSrpg.database.listaCla().getHabilidadPorNombre(filtro)
                    var objetos : List<Habilidad> = auxDao.getHabilidadPorNombre(filtro)
                    adapter = HabilidadAdapter(objetos)
                }
                runOnUiThread { true }

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