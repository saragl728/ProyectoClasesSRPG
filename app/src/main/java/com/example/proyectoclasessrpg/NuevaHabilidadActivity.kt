package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Habilidad
import com.example.proyectoclasessrpg.databinding.ActivityNuevaHabilidadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaHabilidadActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNuevaHabilidadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir habilidad"

        //si se intenta añadir una habilidad
        binding.bAnyadirHabilidad.setOnClickListener {
            try{
                var nomHabilidad = Estatico.FormatSimple(binding.nomHabilidad.editText?.text.toString(), "El nombre de la habilidad no puede estar en blanco")
                var descrip = Estatico.FormatSimple(binding.tDescripcion.editText?.text.toString(), "La descripción de la habilidad no puede estar en blanco")
                var habilidad = Habilidad(nomHabilidad, descrip)
                CoroutineScope(Dispatchers.IO).launch {
                    auxDao.addHabilidad(habilidad)
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
                    actividadActual = 4
                    startActivity(Intent(this, ListadoHabilidadesActivity::class.java))

                })
                //no se hará nada en la opción de cancelar
                .setNegativeButton(android.R.string.cancel, { dialog, which ->})

            //mostrará el cuadro de diálogo
            aviso.show()
        }
    }
}