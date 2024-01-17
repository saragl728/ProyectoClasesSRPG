package com.example.proyectoclasessrpg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoclasessrpg.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Nuevo usuario"

        binding.botonRegistro.setOnClickListener {
            //se comprueba si hay algo en blanco
            if (binding.email.text.toString().isNotEmpty() && binding.contrasenya.text.toString()
                    .isNotEmpty() && binding.nombreCompleto.text.toString()
                    .isNotEmpty() && binding.nombreUsuario.text.toString().isNotEmpty()
            ) {
                //se intentará registrar la cuenta
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.text.toString(), binding.contrasenya.text.toString()
                ). addOnCompleteListener {
                    //si funciona, irá a la actividad de la lista de clases
                    if (it.isSuccessful){
                        val intent = Intent(this, ListadoClasesActivity::class.java)
                        startActivity(intent)
                    }
                    //si no se puede registrar el usuario, se mostrará un mensaje de error
                    else{
                        Toast.makeText(this, "No se ha podido añadir el usuario", Toast.LENGTH_LONG).show()
                    }
                }

            }
            //si se ha dejado algo en blanco, se avisa
            else{
                Toast.makeText(this, "Hay un campo en blanco", Toast.LENGTH_LONG).show()
            }
        }
    }
}