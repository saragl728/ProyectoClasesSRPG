package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ClaseAdapter
import com.example.proyectoclasessrpg.databinding.ActivityListadoClasesBinding
import com.example.proyectoclasessrpg.provider.ClaseProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoClasesActivity : ActividadConMenus() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoClasesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de clases"

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoClasesActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = ClaseAdapter(auxDao.getAllClases())

            }
            runOnUiThread { true }
        }

        //binding.recycler.layoutManager = LinearLayoutManager(this)
        var adapter = ClaseAdapter(ClaseProvider.listaClases)


        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")
                CoroutineScope(Dispatchers.IO).launch {
                    //var objetos : List<Clase> = auxDao.getClasesPorNombre(filtro)
                    var objetos = auxDao.getClasesPorNombre(filtro)
                    //binding.recycler.adapter = ClaseAdapter(objetos)
                    binding.recycler.apply {
                        adapter = ClaseAdapter(objetos)
                        Log.d("Búsqueda", "Hay ${objetos.count()} objetos")
                    }
                }
                runOnUiThread { true }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }


        binding.bMas.setOnClickListener {
            actividadActual = 1
            startActivity(Intent(this, NuevaClaseActivity::class.java))
        }

    }

}