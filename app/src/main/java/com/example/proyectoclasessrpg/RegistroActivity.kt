package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonRegistro.setOnClickListener {
            //se comprueba si hay algo en blanco
            if (binding.email.text.toString().isNotEmpty() && binding.contrasenya.text.toString()
                    .isNotEmpty() && binding.nombreCompleto.text.toString()
                    .isNotEmpty() && binding.nombreUsuario.text.toString().isNotEmpty()
            ) {
                //se intentará registrar la cuenta
            }
            //si se ha dejado algo en blanco, se avisa
            else{
                Toast.makeText(this, "Hay un campo en blanco", Toast.LENGTH_LONG).show()
            }
        }
    }
}