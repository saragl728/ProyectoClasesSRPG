package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Arma
import com.example.proyectoclasessrpg.databinding.ActivityNuevaArmaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaArmaActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNuevaArmaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir tipo de arma"

        binding.bAnyadirArma.setOnClickListener {
            try {
                var nomArma : String = Estatico.FormatSimple(binding.nomArma.editText?.text.toString(), "El tipo de arma no se puede dejar en blanco")
                var arma = Arma(nomArma)
                //se procede a la insercción en la base de datos
                CoroutineScope(Dispatchers.IO).launch {
                    //ProyectoSrpg.database.listaCla().addArma(arma)
                    auxDao.addArma(arma)
                }
                runOnUiThread { true }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }

        }

        binding.bVolver.setOnClickListener {
            var aviso = AlertDialog.Builder(this)

            aviso.setTitle("Aviso")
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres dejar de añadir objetos?")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    actividadActual = 6
                    startActivity(Intent(this, ListadoArmasActivity::class.java))

                })
                //no se hará nada en la opción de cancelar
                .setNegativeButton(android.R.string.cancel, { dialog, which ->})

            aviso.show()
        }
    }
}