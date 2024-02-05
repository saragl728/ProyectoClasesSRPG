package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityConectarClasesOtrosBinding

class ConectarClasesOtrosActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConectarClasesOtrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Clases con otros elementos"


        binding.bAnyadir.setOnClickListener {
            //como se van a conectar clases con otros elementos, primero se comprueba que se ha escrito la clase
            if (binding.clase.text.toString().isNotEmpty()){
                //se hará otra comprobación dependiendo del radio button seleccionado
                if (binding.radioArma.isChecked){
                    if (binding.arma.text.toString().isNotEmpty()){

                    }
                    else{
                        Toast.makeText(this, "Hay que introducir el tipo de arma", Toast.LENGTH_LONG).show()
                    }
                }
                if (binding.radioHabilidad.isChecked){
                    if (binding.habilidad.text.toString().isNotEmpty()){

                    }
                    else{
                        Toast.makeText(this, "Hay que introducir la habilidad", Toast.LENGTH_LONG).show()
                    }
                }
                if (binding.radioPropiedad.isChecked){
                    if (binding.propiedad.text.toString().isNotEmpty()){

                    }
                    else{
                        Toast.makeText(this, "Hay que introducir la propiedad", Toast.LENGTH_LONG).show()
                    }
                }

            }
            else{
                Toast.makeText(this, "Hay que escribir el nombre de la clase", Toast.LENGTH_LONG).show()
            }
        }
    }
}