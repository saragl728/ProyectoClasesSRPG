package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ClaseAdapter
import com.example.proyectoclasessrpg.database.Clase
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

        binding.recycler.layoutManager = LinearLayoutManager(this)
        var adapter = ClaseAdapter(ClaseProvider.listaClases)
        binding.recycler.adapter = adapter

        binding.bBuscar.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")
                CoroutineScope(Dispatchers.IO).launch {
                    //var objetos : List<Clase> = ProyectoSrpg.database.listaCla().getClasesPorNombre(filtro)
                    var objetos : List<Clase> = auxDao.getClasesPorNombre(filtro)
                    adapter = ClaseAdapter(objetos)
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