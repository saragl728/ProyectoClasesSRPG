package com.example.proyectoclasessrpg.adapter

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoclasessrpg.InfoActivity
import com.example.proyectoclasessrpg.ListadoClasesActivity
import com.example.proyectoclasessrpg.MainActivity
import com.example.proyectoclasessrpg.NuevaClaseActivity
import com.example.proyectoclasessrpg.R
import com.google.firebase.auth.FirebaseAuth

open class ActividadConMenus : AppCompatActivity() {
    companion object {
        var actividadActual = 0;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //relacionamos la clase con el layout del menú que hennos creado
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        //desactivar la opción de la actividad en la que estamos
        for (i in 0 until  menu.size()){
            if (i == actividadActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            //para la actividad del listado de clases
            R.id.listaClases -> {
                val intent = Intent(this, ListadoClasesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 0
                true
            }
            //para ir a la actividad de añadir clases
            R.id.anyadirClases -> {
                val intent = Intent(this, NuevaClaseActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 1
                true
            }

            //info te lleva a la actividad que muestra información sobre la aplicación
            R.id.info -> {
                val intent = Intent(this, InfoActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 10
                true
            }
            R.id.adios -> {
                FirebaseAuth.getInstance().signOut()
                //se vuelve al inicio después de cerrar sesión
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}