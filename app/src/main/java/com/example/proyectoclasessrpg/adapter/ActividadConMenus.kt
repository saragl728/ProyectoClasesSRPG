package com.example.proyectoclasessrpg.adapter

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoclasessrpg.ClasesObjetosActivity
import com.example.proyectoclasessrpg.ConectarClasesOtrosActivity
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
import com.example.proyectoclasessrpg.database.DBPr
import com.example.proyectoclasessrpg.database.Dao
import com.google.firebase.auth.FirebaseAuth

open class ActividadConMenus : AppCompatActivity() {
    companion object {
        var actividadActual = 0;
    }

    lateinit var sonidoApaga: MediaPlayer   //sonido para cuando cierre sesión
    lateinit var sonidoPopUp: MediaPlayer   //sonido para cuando salga un AlertDialog
    lateinit var sonidoError: MediaPlayer   //sonido de error
    lateinit var auxDao: Dao


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sonidoError = MediaPlayer.create(this, R.raw.windowsxperror)
        sonidoPopUp = MediaPlayer.create(this, R.raw.windowsxpballoon)

        var db = DBPr.getInstance(this)
        auxDao = db.listaCla()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //relacionamos la clase con el layout del menú que hemos creado
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        //desactivar la opción de la actividad en la que estamos
        for (i in 0 until menu.size()) {
            if (i == actividadActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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
                val intent = Intent(this, NuevaPromocionActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 3
                true
            }

            R.id.listaHabilidades -> {
                val intent = Intent(this, ListadoHabilidadesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 4
                true
            }

            R.id.anyadirHabilidad -> {
                val intent = Intent(this, NuevaHabilidadActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 5
                true
            }

            R.id.listaTiposArmas -> {
                val intent = Intent(this, ListadoArmasActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 6
                true
            }

            R.id.anyadirTipoArma -> {
                val intent = Intent(this, NuevaArmaActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 7
                true
            }

            R.id.listaPropiedades -> {
                val intent = Intent(this, ListadoPropiedadesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 8
                true
            }

            R.id.anyadirPropiedad -> {
                val intent = Intent(this, NuevaPropiedadActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 9
                true
            }

            R.id.clasesOtros -> {
                val intent = Intent(this, ConectarClasesOtrosActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 10
                true
            }

            R.id.buscarClasesOtros -> {
                val intent = Intent(this, ClasesObjetosActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent)
                actividadActual = 11
                true
            }

            R.id.adios -> {
                //asigna un valor al objeto de sonido
                sonidoApaga = MediaPlayer.create(this, R.raw.windowsxpshutdown)

                sonidoPopUp.start()
                //pregunta al usuario si quiere cerrar sesión
                var aviso = AlertDialog.Builder(this)
                aviso.setTitle("Aviso")
                aviso.setIcon(R.drawable.pregunta)
                aviso.setMessage("¿Seguro que quieres cerrar sesión?")
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        //reproducirá el sonido de apagado
                        sonidoApaga.start()

                        //intentará cerrar sesión e ir a la actividad principal
                        FirebaseAuth.getInstance().signOut()
                        startActivity(Intent(this, MainActivity::class.java))

                        //se pone como actividad actual la 0 para que cuando se vuelva a iniciar sesión, no se quede anulada la actividad desde la que se cierra sesión
                        actividadActual = 0
                    })
                    //no se hará nada en la opción de cancelar
                    .setNegativeButton(android.R.string.cancel, { dialog, which ->})

                //mostrará el cuadro de diálogo
                aviso.show()
                true
            }

            R.id.info -> {
                var mensaje = ""
                //hago que el mensaje que muestre cambie en función de la actividad
                when (actividadActual) {
                    0 -> mensaje = "Aquí puedes ver las diferentes clases que hay. También puedes eliminar una clase seleccionándola."
                    1 -> mensaje = "Aquí puedes añadir clases. Recuerda que no puedes dejar campos en blanco, los nombres internos de las clases se pondrán en mayúsculas y se eliminarán los espacios en blanco de los elementos que insertes."
                    2 -> mensaje = "Aquí puedes ver el listado de promociones de las clases. También puedes eliminar una seleccionándola."
                    3 -> mensaje = "Aquí puedes añadir promociones entre clases. Recuerda que no es posible que la clase base y la clase avanzada tengan el mismo nombre interno."
                    4 -> mensaje = "Aquí puedes ver las diferentes habilidades que hay. También puedes eliminar una habilidad seleccionándola."
                    5 -> mensaje = "Aquí puedes añadir habilidades. Recuerda que las habilidades se distinguen por su nombre y que no puedes dejar la descripción en blanco."
                    6 -> mensaje = "Aquí puedes los tipos de armas que las clases pueden usar."
                    7 -> mensaje = "Aquí puedes añadir nuevos tipos de armas."
                    8 -> mensaje = "Aquí puedes ver las diferentes propiedades que pueden estar asociadas a las clases."
                    9 -> mensaje = "Aquí puedes añadir nuevas propiedades."
                    10 -> mensaje = "Aquí puedes conectar clases con otros elementos como habilidades, tipos de armas o propiedades."
                    11 -> mensaje = "Aquí puedes ver las conexiones entre clases y habilidades/tipos de armas/propiedades."
                }

                //muestra un AlertDialog aclarando cosas sobre la actividad actual

                //hago que suene el popUp
                sonidoPopUp.start()

                var aviso = AlertDialog.Builder(this)
                aviso.setTitle("Información")
                aviso.setIcon(R.drawable.info)
                aviso.setMessage(mensaje)

                aviso.show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
    }