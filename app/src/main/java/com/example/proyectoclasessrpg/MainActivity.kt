package com.example.proyectoclasessrpg

import android.content.Intent
import android.os.Bundle
import com.example.proyectoclasessrpg.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ActividadesUsuarios() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        title = "Inicio"

        //iniciar sesión
        binding.bLogin.setOnClickListener {
            try {
                val usuario = Estatico.FormatBase(binding.email.editText?.text.toString(), "El correo no puede estar en blanco")
                val contrase = Estatico.FormatBase(binding.passwd.editText?.text.toString(), "La contraseña no puede estar en blanco")

                FirebaseAuth.getInstance().signInWithEmailAndPassword(usuario, contrase).addOnCompleteListener {
                    if (it.isSuccessful){
                        //te lleva a otra actividad y suena el sonido de inicio
//                        sonidoInicio.start()
//                        val intent = Intent(this, ListadoClasesActivity::class.java)
//                        startActivity(intent)
                        InicioSesion()
                    }
                    else{
                        Estatico.MensajeConSonido("Usuario o contraseña incorrectos", sonidoError, this)
                    }
                }

            }
            catch (e: Exception){
                Estatico.MensajeConSonido(e.message.toString(), sonidoError, this)
            }
        }

        //registrarse
        binding.bRegistro.setOnClickListener {
            //se llama a la actividad de registro
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        //contraseña olvidada
        binding.bConOlvid.setOnClickListener {
            startActivity(Intent(this, ContOlvidadaActivity::class.java))
        }

    }
}