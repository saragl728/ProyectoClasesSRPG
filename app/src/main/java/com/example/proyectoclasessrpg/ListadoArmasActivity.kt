package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ArmaAdapter
import com.example.proyectoclasessrpg.database.Arma
import com.example.proyectoclasessrpg.databinding.ActivityListadoArmasBinding
import com.example.proyectoclasessrpg.provider.ArmaProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoArmasActivity : ActividadConMenus() {
    lateinit var listaObjetos :List<Arma>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoArmasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de tipos de armas"


        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoArmasActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = ArmaAdapter(auxDao.getAllArmas())
            }
            runOnUiThread { true }
        }

        var adapter = ArmaAdapter(ArmaProvider.listaArma)

        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomArma.editText?.text.toString(), "Hay que poner algo que buscar")
                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getArmasConNombre(filtro)

                }
                runOnUiThread { true
                    binding.recycler.apply {
                        adapter = ArmaAdapter(listaObjetos)
                    }
                }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        binding.bMas.setOnClickListener {
            actividadActual = 7
            startActivity(Intent(this, NuevaArmaActivity::class.java))
        }
    }
}