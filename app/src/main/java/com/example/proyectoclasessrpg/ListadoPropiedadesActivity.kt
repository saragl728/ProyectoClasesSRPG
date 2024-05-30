package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.PropiedadAdapter
import com.example.proyectoclasessrpg.database.Propiedad
import com.example.proyectoclasessrpg.databinding.ActivityListadoPropiedadesBinding
import com.example.proyectoclasessrpg.provider.PropiedadProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoPropiedadesActivity : ActividadConMenus() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoPropiedadesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de propiedades"

        binding.recycler.layoutManager = LinearLayoutManager(this)
         var adapter = PropiedadAdapter(PropiedadProvider.listaPropiedad)
        binding.recycler.adapter = adapter
                

        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomProp.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {

                        //var objetos : List<Propiedad> = ProyectoSrpg.database.listaCla().getPropiedadPorNombre(filtro)
                    var objetos : List<Propiedad> = auxDao.getPropiedadPorNombre(filtro)
                        adapter = PropiedadAdapter(objetos)
                    }
                    runOnUiThread { true }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        binding.bMas.setOnClickListener {
            actividadActual = 9
            startActivity(Intent(this, NuevaPropiedadActivity::class.java))
        }

    }
}