package com.example.proyectoclasessrpg

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import com.example.proyectoclasessrpg.databinding.ActivityContOlvidadaBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ContOlvidadaActivity : ActividadesUsuarios() {
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Contraseña Olvidada"
        super.onCreate(savedInstanceState)

        var binding = ActivityContOlvidadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bEnvio.setOnClickListener {
            try {
                val email = Estatico.FormatBase(binding.layoutEmail.editText?.text.toString(), "El correo no puede estar en blanco")
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) throw Exception("Correo no válido")

                var firebaseAuth = FirebaseAuth.getInstance()
                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            //añadir un snackBar diciéndole al usuario que se ha enviado un correo y le dará la opción de volver a la actividad principal
                            var snackbar : Snackbar = Snackbar.make(binding.root, "Se ha enviado un correo", BaseTransientBottomBar.LENGTH_INDEFINITE).setAction("Volver"){
                               val intent = Intent(this, MainActivity::class.java)
                           startActivity(intent)
                            }.setActionTextColor(Color.CYAN)
                            snackbar.show()

                        }
                    }
                }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }
    }
}