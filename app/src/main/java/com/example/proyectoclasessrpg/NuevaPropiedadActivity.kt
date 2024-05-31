package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Propiedad
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPropiedadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaPropiedadActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaPropiedadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir propiedad"

        binding.bAnyadirPropiedad.setOnClickListener {
            try {
                val prop = Estatico.FormatSimple(binding.nomPropiedad.editText?.text.toString(), "El nombre de la propiedad no puede estar en blanco")
                var proppi = Propiedad(prop)
                CoroutineScope(Dispatchers.IO).launch {
                    auxDao.addPropiedad(proppi)
                }
                runOnUiThread { true }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        binding.bVolver.setOnClickListener {
            var aviso = AlertDialog.Builder(this)

            aviso.setTitle("Aviso").setIcon(R.drawable.pregunta)
            aviso.setIcon(R.drawable.pregunta)
            aviso.setMessage("¿Seguro que quieres dejar de añadir objetos?")
                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    actividadActual = 8
                    startActivity(Intent(this, ListadoPropiedadesActivity::class.java))

                })
                //no se hará nada en la opción de cancelar
                .setNegativeButton(android.R.string.cancel, { dialog, which ->})

            //mostrará el cuadro de diálogo
            aviso.show()
        }
    }
}