package com.example.proyectoclasessrpg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.PromocionAdapter
import com.example.proyectoclasessrpg.database.Promocion
import com.example.proyectoclasessrpg.databinding.ActivityListadoPromocionesBinding
import com.example.proyectoclasessrpg.provider.PromocionProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoPromocionesActivity : ActividadConMenus() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoPromocionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de promociones"

//        binding.recycler.layoutManager = LinearLayoutManager(this)
//
//        binding.recycler.adapter = adapter

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoPromocionesActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = PromocionAdapter(auxDao.getAllPromociones())
            }
            runOnUiThread { true }
        }

        var adapter = PromocionAdapter(PromocionProvider.listaPromociones)

        //para buscar clases que promocionan a la que se busca
        binding.bPromoA.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")

                    CoroutineScope(Dispatchers.IO).launch {
                        var objetos = auxDao.getPromosDeBase(filtro)
                        adapter = PromocionAdapter(objetos)
                    }
                    runOnUiThread { true }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }

        }

        //para buscar clases que promocionan de la que se busca
        binding.bPromoDe.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    var objetos = auxDao.getPromosHaciaPromo(filtro)
                    adapter = PromocionAdapter(objetos)
                }
                runOnUiThread { true }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }

        }

        binding.bMas.setOnClickListener {
            actividadActual = 3
            startActivity(Intent(this, NuevaPromocionActivity::class.java))
        }
    }
}