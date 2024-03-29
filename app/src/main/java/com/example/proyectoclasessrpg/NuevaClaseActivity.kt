package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.databinding.ActivityNuevaClaseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaClaseActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaClaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Añadir clase"

        //cuando se intenta añadir una clase
        binding.bAnyadirClase.setOnClickListener {
            //variable que se va a necesitar para una validación
            var movimiento = binding.movimiento.text.toString().toInt()
            //se comprueba si se han rellenado los campos
            if (binding.nombreInterno.text.toString()
                    .isNotEmpty() && binding.nombreVisible.text.toString()
                    .isNotEmpty() && binding.movimiento.text.toString().isNotEmpty() && (binding.descripcion.text.toString().isNotEmpty())
            ) {
                //antes de intentar añadirlo, comprueba que el movimiento no es inferior a 0
                if (movimiento < 0) {
                    Toast.makeText(
                        this,
                        "El movimiento de la clase no puede ser inferior a 0",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    //intentará añadir la clase nueva a la base de datos
                    val clase = Clase(binding.nombreInterno.text.toString(), binding.nombreVisible.text.toString(),
                        binding.descripcion.text.toString(), (binding.movimiento.text.toString().toInt()))

                    CoroutineScope(Dispatchers.IO).launch {
                        //val id = ProyectoSRPG.database.
                    }


                }
            }
            //si hay un campo vacío se avisa
            else {
                Toast.makeText(this, "Hay al menos un campo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}