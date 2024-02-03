package com.example.proyectoclasessrpg.adapter

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoclasessrpg.ListadoArmasActivity
import com.example.proyectoclasessrpg.ListadoClasesActivity
import com.example.proyectoclasessrpg.ListadoHabilidadesActivity
import com.example.proyectoclasessrpg.ListadoPromocionesActivity
import com.example.proyectoclasessrpg.ListadoPropiedadesActivity
import com.example.proyectoclasessrpg.MainActivity
import com.example.proyectoclasessrpg.NuevaArmaActivity
import com.example.proyectoclasessrpg.NuevaClaseActivity
import com.example.proyectoclasessrpg.NuevaHabilidadActivity
import com.example.proyectoclasessrpg.NuevaPromocionActivity
import com.example.proyectoclasessrpg.NuevaPropiedadActivity
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
            R.id.promociones -> {
                val intent = Intent(this, ListadoPromocionesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 2
                true
            }

            R.id.anyadirPromociones -> {
                val intent = Intent(this,NuevaPromocionActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 3
                true
            }
            R.id.listaHabilidades -> {
                val intent = Intent(this,ListadoHabilidadesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 4
                true
            }
            R.id.anyadirHabilidad -> {
                val intent = Intent(this,NuevaHabilidadActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 5
                true
            }

            R.id.listaTiposArmas -> {
                val intent = Intent(this,ListadoArmasActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 6
                true
            }
            R.id.anyadirTipoArma -> {
                val intent = Intent(this,NuevaArmaActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 7
                true
            }
            R.id.listaPropiedades -> {
                val intent = Intent(this,ListadoPropiedadesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 8
                true
            }
            R.id.anyadirPropiedad -> {
                val intent = Intent(this,NuevaPropiedadActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 9
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