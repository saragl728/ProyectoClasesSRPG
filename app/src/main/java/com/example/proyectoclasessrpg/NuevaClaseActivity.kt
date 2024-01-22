package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaClaseBinding

class NuevaClaseActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaClaseBinding.inflate(layoutInflater)

        //cuando se intenta añadir una clase
        binding.bAnyadirClase.setOnClickListener {
            //se comprueba si se han rellenado los campos
            if (binding.nombreInterno.text.toString().isNotEmpty() && binding.nombreVisible.text.toString().isNotEmpty()){
                //si se han rellenado debería intentar añadir la clase a la base de datos
            }
            //si hay un campo vacío se avisa
            else{
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}