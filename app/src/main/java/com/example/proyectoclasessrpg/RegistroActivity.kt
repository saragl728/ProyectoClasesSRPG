package com.example.proyectoclasessrpg

import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : ActividadesUsuarios() {

    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Nuevo usuario"

        binding.botonRegistro.setOnClickListener {
            try {
                var correo = Estatico.FormatBase(binding.correo.editText?.text.toString(), "El email no puede estar en blanco")
                var contrase = Estatico.ValidarPasswd(binding.passwd.editText?.text.toString())

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, contrase).addOnCompleteListener {
                    if (it.isSuccessful){
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, contrase)
                        InicioSesion()
                }
                    else throw Exception("No se ha podido añadir el usuario")
            }
            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }

        }
    }
}