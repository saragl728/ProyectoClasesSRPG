package com.example.proyectoclasessrpg

import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast

class Estatico {
    companion object {
        //Método que muestra una tostada y hacer sonar un efecto de sonido
        fun MensajeConSonido(tostada: String, sonido : MediaPlayer, contexto: Context){
            sonido.start()
            Toast.makeText(contexto, tostada, Toast.LENGTH_SHORT).show()
        }

        //devuelve una cadena recortada sin espacios en mayúsculas
        fun FormatMayus(entrada: String, mensajeError: String) : String {
            var aux = entrada.trim()
            if (aux.length == 0) throw Exception(mensajeError)
            aux = aux.uppercase()
            return aux
        }

        //devuelve una cadena sin espacios en blanco y con la primera letra en mayúsculas
        fun FormatSimple(entrada: String, mensajeError: String) : String {
            var aux = entrada.trim()
            if (aux.length == 0) throw Exception(mensajeError)
            var cInicio : String = aux[0].toString()
            var cNuevo : String = cInicio.uppercase()

            aux.replaceFirst(cInicio, cNuevo, true)

            return aux
        }

        //devuelve una cadena recortada sin espacios
        fun FormatBase(entrada: String, mensajeError: String) : String {
            var aux = entrada.trim()
            if (aux.length == 0) throw Exception(mensajeError)
            return aux
        }

        //método para validar una contraseña nueva
        fun ValidarPasswd(entrada: String): String{
            val longMin = 3 //longitud mínima
            var aux = entrada.trim()
            //si después de recortar la cadena de entrada, es demasiado corta, lanza una excepción
            if (aux.length < longMin) throw Exception("La longitud de la contraseña debe ser igual o superior a $longMin caracteres")

            //variables para comprobar si hay letras y dígitos
            var hayLetras = false
            var hayDigitos = false
            var i = 0
            do {
                if (aux[i].isDigit()) hayDigitos = true
                if (aux[i].isLetter()) hayLetras = true
                i++
            } while (i < aux.length && (!hayDigitos || !hayLetras))

            //si no hay letras y/o dígitos, se lanza una excepción
            if (!hayLetras) throw Exception("La contraseña debe contener letras")
            if (!hayDigitos) throw Exception("La contraseña debe contener dígitos")

            return  aux
        }

    }
}