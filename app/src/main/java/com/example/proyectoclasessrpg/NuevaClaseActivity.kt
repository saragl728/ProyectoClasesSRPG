package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.databinding.ActivityNuevaClaseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaClaseActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNuevaClaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir clase"


        //cuando se intenta añadir una clase
        binding.bAnyadirClase.setOnClickListener {
            try {
                //variables que se va a necesitar para una validación
                var movimiento = binding.nMovimiento.editText?.text.toString().toInt()
                var nomInterno = Estatico.FormatMayus(binding.nomInterno.editText?.text.toString(), "El nombre interno no puede estar en blanco")
                var nomVisible = Estatico.FormatSimple(binding.nomVisible.editText?.text.toString(), "El nombre visible no puede estar en blanco")
                var descrip = Estatico.FormatSimple(binding.tDescripcion.editText?.text.toString(), "La descripción no puede estar en blanco")
                if (movimiento < 0) throw Exception("El movimiento de la clase no puede ser inferior a 0")
                //intentará añadir la clase nueva a la base de datos
                val clase = Clase(nomInterno, nomVisible, descrip, movimiento)

                CoroutineScope(Dispatchers.IO).launch {
                    val id = auxDao.addClase(clase)
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
                    actividadActual = 0
                    startActivity(Intent(this, ListadoClasesActivity::class.java))

                })
                //no se hará nada en la opción de cancelar
                .setNegativeButton(android.R.string.cancel, { dialog, which ->})

            //mostrará el cuadro de diálogo
            aviso.show()
        }
    }
}