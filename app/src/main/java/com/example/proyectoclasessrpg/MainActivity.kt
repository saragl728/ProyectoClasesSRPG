package com.example.proyectoclasessrpg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Inicio"

        //iniciar sesión
        binding.bLogin.setOnClickListener {
            //se comprueba si hay campos vacíos
            if (binding.correo.text.toString().isNotEmpty() && binding.contrasenya.text.toString().isNotEmpty()){
                //si no hay campos vacíos, debería intentar iniciar sesión
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.correo.text.toString(), binding.contrasenya.text.toString()).addOnCompleteListener {
                    //si funciona, irá a la actividad con el listado de clases
                    if (it.isSuccessful){
                        val intent = Intent(this, ListadoClasesActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                //avisa si no hay un campo vacío
                Toast.makeText(this, "Hay un campo vacío", Toast.LENGTH_LONG).show()
            }
        }

        //registrarse
        binding.bRegistro.setOnClickListener {
            //se llama a la actividad de registro
            startActivity(Intent(this, RegistroActivity::class.java))
        }
    }
}