package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaClaseBinding

class NuevaClaseActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Añadir clase"

        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaClaseBinding.inflate(layoutInflater)

        //cuando se intenta añadir una clase
        binding.bAnyadirClase.setOnClickListener {
            //variable que se va a necesitar para una validación
            var movimiento = binding.movimiento.text.toString().toInt()
            //se comprueba si se han rellenado los campos
            if (binding.nombreInterno.text.toString()
                    .isNotEmpty() && binding.nombreVisible.text.toString()
                    .isNotEmpty() && binding.movimiento.text.toString().isNotEmpty()
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
                }
            }
            //si hay un campo vacío se avisa
            else {
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}