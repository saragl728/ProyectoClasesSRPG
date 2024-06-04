package com.example.proyectoclasessrpg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.PromocionAdapter
import com.example.proyectoclasessrpg.database.Promocion
import com.example.proyectoclasessrpg.databinding.ActivityListadoPromocionesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoPromocionesActivity : ActividadConMenus() {

    lateinit var listaObjetos : List<Promocion>
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityListadoPromocionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Lista de promociones"

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ListadoPromocionesActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = PromocionAdapter(auxDao.getAllPromociones())
            }
            runOnUiThread { true }
        }

        //para buscar clases que promocionan a la que se busca
        binding.bPromoDe.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getPromosDeBase(filtro)
                }
                runOnUiThread {
                    muestraResultados(binding.recycler, listaObjetos)
                }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        //para buscar clases que promocionan de la que se busca
        binding.bPromoA.setOnClickListener {
            try {
                var filtro = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que poner algo que buscar")

                CoroutineScope(Dispatchers.IO).launch {
                    listaObjetos = auxDao.getPromosHaciaPromo(filtro)
                }
                runOnUiThread {
                    muestraResultados(binding.recycler, listaObjetos)
                }

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

    fun muestraResultados(reciclador: RecyclerView, resultados: List<Promocion>){
        reciclador.apply {
            adapter = PromocionAdapter(resultados)
        }
    }

}