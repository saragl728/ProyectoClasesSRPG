package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ClaseAdapter
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.databinding.ActivityListadoClasesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoClasesActivity : ActividadConMenus() {

    lateinit var listaObjetos :List<Clase>
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


        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")
                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getClasesPorNombre(filtro)
                }
                runOnUiThread { true
                    binding.recycler.apply {
                        adapter = ClaseAdapter(listaObjetos)
                    }
                }

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