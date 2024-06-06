package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Arma
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.database.ClaseArma
import com.example.proyectoclasessrpg.database.ClaseHabilidad
import com.example.proyectoclasessrpg.database.ClasePropiedad
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.database.Propiedad
import com.example.proyectoclasessrpg.databinding.ActivityConectarClasesOtrosBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConectarClasesOtrosActivity : ActividadConMenus() {
    lateinit var auxClase: MutableList<Clase>
    lateinit var auxHabil: MutableList<Habilidad>
    lateinit var auxProp: MutableList<Propiedad>
    lateinit var auxArma: MutableList<Arma>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityConectarClasesOtrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Clases con otros elementos"
        auxClase = mutableListOf()
        auxHabil = mutableListOf()
        auxProp = mutableListOf()
        auxArma = mutableListOf()

        sonidoPopUp = MediaPlayer.create(this, R.raw.windowsxpballoon)

        binding.bAnyadir.setOnClickListener {
            try {
                var nomClase = Estatico.FormatMayus(binding.nomClase.editText?.text.toString(), "Hay que escribir el nombre de la clase")
                CoroutineScope(Dispatchers.IO).launch {
                   auxClase = auxDao.getClaseEspecifica(nomClase)
                }
                ListaTieneObjetos(auxClase, "No se puede introducir este dato porque la clase $nomClase no existe")

                when{
                    binding.radioArma.isChecked -> {
                        var nomArma = Estatico.FormatSimple(binding.nomArma.editText?.text.toString(), "Hay que introducir el tipo de arma")
                        var claArma = ClaseArma(nomClase, nomArma)
                        CoroutineScope(Dispatchers.IO).launch {
                            auxArma = auxDao.getArmaEspecifica(nomArma)
                        }
                        ListaTieneObjetos(auxArma, "No se puede introducir este dato porque el tipo de arma $nomArma no existe")
                        CoroutineScope(Dispatchers.IO).launch {
                            val id = auxDao.addClaseConArma(claArma)
                        }
                        runOnUiThread { true }

                    }
                    binding.radioHabilidad.isChecked -> {
                        var habilidad = Estatico.FormatSimple(binding.nomHabilidad.editText?.text.toString(), "Hay que introducir la habilidad")
                        var claHabi = ClaseHabilidad(nomClase, habilidad)
                        CoroutineScope(Dispatchers.IO).launch {
                            auxHabil = auxDao.getHabilidadEspecifica(habilidad)
                        }
                        ListaTieneObjetos(auxHabil, "No se puede introducir este dato porque la habilidad $habilidad no existe")
                        CoroutineScope(Dispatchers.IO).launch {
                            val id = auxDao.addClaseConHabilidad(claHabi)
                        }
                        runOnUiThread { true }

                    }
                    binding.radioPropiedad.isChecked -> {
                        var propied = Estatico.FormatSimple(binding.nombrePropiedad.editText?.text.toString(), "Hay que introducir la propiedad")
                        var claProp = ClasePropiedad(nomClase, propied)
                        CoroutineScope(Dispatchers.IO).launch {
                            auxProp = auxDao.getPropiedadEspecifica(propied)
                        }
                        ListaTieneObjetos(auxProp, "No se puede introducir este dato porque la propiedad $propied no existe")
                        CoroutineScope(Dispatchers.IO).launch {
                            val id = auxDao.addClaseConPropiedad(claProp)
                        }
                        runOnUiThread { true }
                    }
                    else -> Estatico.MensajeConSonido("No se ha seleccionado ninguna opción", sonidoError, this)

                }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        binding.bVolver.setOnClickListener {
            val aviso = AlertDialog.Builder(this)

            aviso.setTitle("Aviso")

            aviso.setIcon(R.drawable.pregunta)

                aviso.setMessage("¿Seguro que quieres dejar de añadir objetos?")
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        actividadActual = 11
                        startActivity(Intent(this, ClasesObjetosActivity::class.java))

                    })
                    //no se hará nada en la opción de cancelar
                    .setNegativeButton(android.R.string.cancel, { dialog, which ->})

                //mostrará el cuadro de diálogo
                aviso.show()
        }
    }
}