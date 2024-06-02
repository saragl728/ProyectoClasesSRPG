package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.PropiedadAdapter
import com.example.proyectoclasessrpg.database.Propiedad
import com.example.proyectoclasessrpg.databinding.ActivityListadoPropiedadesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoPropiedadesActivity : ActividadConMenus() {

    lateinit var listaObjetos : List<Propiedad>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoPropiedadesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de propiedades"


        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoPropiedadesActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = PropiedadAdapter(auxDao.getAllPropiedades())
            }
            runOnUiThread { true }
        }

        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomProp.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getPropiedadPorNombre(filtro)
                    }
                    runOnUiThread {
                        binding.recycler.apply {
                            adapter = PropiedadAdapter(listaObjetos)
                        }
                    }
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