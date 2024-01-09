package com.example.proyectoclasessrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //iniciar sesión
        binding.bLogin.setOnClickListener {
            //se comprueba si hay campos vacíos
            if (binding.correo.text.toString().isNotEmpty() && binding.contrasenya.text.toString().isNotEmpty()){
                //si no hay campos vacíos, debería intentar iniciar sesión
            }
            else{
                //avisa si no hay un campo vacío
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }

        //registrarse
        binding.bRegistro.setOnClickListener {
            //tiene que ir a la actividad de registro
        }
    }
}