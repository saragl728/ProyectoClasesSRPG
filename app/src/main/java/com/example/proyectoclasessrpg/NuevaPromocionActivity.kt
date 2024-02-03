package com.example.proyectoclasessrpg

import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.adapter.ActividadConMenus
import com.example.proyectoclasessrpg.databinding.ActivityNuevaPromocionBinding

class NuevaPromocionActivity : ActividadConMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNuevaPromocionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Añadir una promoción de clase"

        binding.bAnyadirPromocion.setOnClickListener {
            if (binding.claseBase.text.toString().isNotEmpty() && (binding.clasePromocionada.text.isNotEmpty())){
                //comprueba que la clase base y la clase promocionadas no son iguales
                if (binding.claseBase.text.toString() == binding.clasePromocionada.text.toString()){
                    Toast.makeText(this, "La clase base no puede ser la misma que la clase promocionada", Toast.LENGTH_LONG).show()
                }
                //si no son iguales, intentará introducir la promoción
                else{

                }
            }
            else{
                Toast.makeText(this, "Hay que rellenar ambos campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}