package com.example.proyectoclasessrpg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.proyectoclasessrpg.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : AppCompatActivity() {

    //para el botón de añadir imagen
    lateinit var imagen: ImageButton
    lateinit var binding: ActivityRegistroBinding
    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            imagen.setImageURI(uri)
        } else {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Nuevo usuario"

        //se intenta añadir una imagen
        binding.botonImagen.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.botonRegistro.setOnClickListener {
            //se comprueba si hay algo en blanco
            if (binding.email.text.toString().isNotEmpty() && binding.contrasenya.text.toString()
                    .isNotEmpty() && binding.nombreUsuario.text.toString().isNotEmpty()
            ) {
                //se intentará registrar la cuenta
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.text.toString(), binding.contrasenya.text.toString()
                ).addOnCompleteListener {
                    //si funciona, irá a la actividad de la lista de clases
                    if (it.isSuccessful) {
                        val intent = Intent(this, ListadoClasesActivity::class.java)
                        startActivity(intent)
                    }
                    //si no se puede registrar el usuario, se mostrará un mensaje de error
                    else {
                        Toast.makeText(this, "No se ha podido añadir el usuario", Toast.LENGTH_LONG)
                            .show()
                    }
                }

            }
            //si se ha dejado algo en blanco, se avisa
            else {
                Toast.makeText(this, "Hay un campo en blanco", Toast.LENGTH_LONG).show()
            }
        }
    }
}