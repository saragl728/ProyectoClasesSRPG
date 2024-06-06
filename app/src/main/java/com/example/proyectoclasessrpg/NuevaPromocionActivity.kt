package com.example.proyectoclasessrpg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.database.Promocion
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPromocionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaPromocionActivity : ActividadConMenus() {
     lateinit var listaAuxA: MutableList<Clase>
     lateinit var listaAuxB: MutableList<Clase>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var binding = ActivityNuevaPromocionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaAuxA = mutableListOf()
        listaAuxB = mutableListOf()

        title = "Añadir una promoción de clase"

        binding.bAnyadirPromocion.setOnClickListener {
            try{
                //primero comprueba que los miembros están bien
                var claseBase = Estatico.FormatMayus(binding.nomClaseBase.editText?.text.toString(), "La clase base no puede estar en blanco")
                var clasePromo = Estatico.FormatMayus(binding.nomClasePromo.editText?.text.toString(), "La clase promocionada no puede estar en blanco")
                if (claseBase == clasePromo) throw Exception("La clase base no puede ser la misma que la clase promocionada")
                CoroutineScope(Dispatchers.IO).launch {
                    listaAuxA = auxDao.getClaseEspecifica(claseBase)
                    listaAuxB = auxDao.getClaseEspecifica(clasePromo)
                }

                ListaTieneObjetos(listaAuxA, "No se puede insertar esta promoción con la clase base $claseBase porque no existe")
                ListaTieneObjetos(listaAuxB, "No se puede insertar esta promoción con la clase avanzada $clasePromo porque no existe")


                var promo = Promocion(claseBase, clasePromo)

                CoroutineScope(Dispatchers.IO).launch {
                    auxDao.addPromocion(promo)
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
                    actividadActual = 2
                    startActivity(Intent(this, ListadoPromocionesActivity::class.java))

                })
                //no se hará nada en la opción de cancelar
                .setNegativeButton(android.R.string.cancel, { dialog, which ->})

            //mostrará el cuadro de diálogo
            aviso.show()
        }
    }
}