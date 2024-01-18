package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.databinding.ActivityNuevaHabilidadBinding

class NuevaHabilidadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaHabilidadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //si se intenta añadir una habilidad
        binding.bAnyadirHabilidad.setOnClickListener {
            //se comprueba si se han rellenado los campos
            if (binding.nombre.text.toString().isNotEmpty() && binding.descripcion.text.toString().isNotEmpty()){

            }
            else{
                //si alguno está vacío, se avisa
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}