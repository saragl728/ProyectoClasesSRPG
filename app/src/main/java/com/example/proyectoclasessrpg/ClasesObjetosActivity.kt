package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.adapter.ClaseArmaAdapter
import com.example.proyectoclasessrpg.adapter.ClaseHabilidadAdapter
import com.example.proyectoclasessrpg.adapter.ClasePropiedadAdapter
import com.example.proyectoclasessrpg.database.ClaseArma
import com.example.proyectoclasessrpg.database.ClaseHabilidad
import com.example.proyectoclasessrpg.database.ClasePropiedad
import com.example.proyectoclasessrpg.databinding.ActivityClasesObjetosBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasesObjetosActivity : ActividadConMenus() {
    lateinit var armaClase : List<ClaseArma>
    lateinit var habiClase : List<ClaseHabilidad>
    lateinit var propClase : List<ClasePropiedad>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityClasesObjetosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Clases con otros objetos"
        binding.recyclerArma.layoutManager = LinearLayoutManager(this)
        binding.recyclerHab.layoutManager = LinearLayoutManager(this)
        binding.recyclerProp.layoutManager = LinearLayoutManager(this)

        binding.recyclerProp.apply {
            layoutManager = LinearLayoutManager(this@ClasesObjetosActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = ClasePropiedadAdapter(auxDao.getClasesConPropiedades())
            }
            runOnUiThread { true }
        }

        binding.recyclerArma.apply {
            layoutManager = LinearLayoutManager(this@ClasesObjetosActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = ClaseArmaAdapter(auxDao.getClasesConArmas())
            }
            runOnUiThread { true }
        }

        binding.recyclerHab.apply {
            layoutManager = LinearLayoutManager(this@ClasesObjetosActivity)
            CoroutineScope(Dispatchers.IO).launch {
                adapter = ClaseHabilidadAdapter(auxDao.getClasesConHabilidades())
            }
            runOnUiThread { true }
        }

        //botón para buscar clases según el tipo de objeto con las que están relacionadas
        binding.boton.setOnClickListener {
            try {
                //comprobación del filtro
                var filtro = Estatico.FormatSimple(binding.tFiltro.editText?.text.toString(), "Hay que introducir algo que buscar")

                if (binding.radioPropiedad.isChecked){
                    binding.recyclerProp.visibility = View.VISIBLE
                    binding.recyclerHab.visibility = View.INVISIBLE
                    binding.recyclerArma.visibility = View.INVISIBLE

                    CoroutineScope(Dispatchers.IO).launch {
                        propClase = auxDao.getClasePorPropiedad(filtro)
                       //var adapter = ClasePropiedadAdapter(objetos)
                        binding.recyclerProp.adapter = ClasePropiedadAdapter(propClase)


                }
                runOnUiThread { true }

                }
                if (binding.radioArma.isChecked){
                    binding.recyclerArma.visibility = View.VISIBLE
                    binding.recyclerHab.visibility = View.INVISIBLE
                    binding.recyclerProp.visibility = View.INVISIBLE
                    CoroutineScope(Dispatchers.IO).launch {
                        //var objetos : List<ClaseArma> = auxDao.getClasePorArma(filtro)
                        armaClase = auxDao.getClasePorArma(filtro)
                        binding.recyclerArma.adapter = ClaseArmaAdapter(armaClase)
                    }
                    runOnUiThread { true }

                }
                if (binding.radioHabilidad.isChecked){
                    binding.recyclerHab.visibility = View.VISIBLE
                    binding.recyclerArma.visibility = View.INVISIBLE
                    binding.recyclerProp.visibility = View.INVISIBLE

                    CoroutineScope(Dispatchers.IO).launch {
                        //var objetos : List<ClaseHabilidad> = auxDao.getClasePorHabilidad(filtro)
                        habiClase = auxDao.getClasePorHabilidad(filtro)
                        binding.recyclerHab.adapter = ClaseHabilidadAdapter(habiClase)
                    }
                    runOnUiThread { true }

                }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }


        binding.bMas.setOnClickListener {
            actividadActual = 10
            startActivity(Intent(this, ConectarClasesOtrosActivity::class.java))
        }

    }
}