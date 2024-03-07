package com.example.proyectoclasessrpg

import android.app.Application
import androidx.room.Room
import com.example.proyectoclasessrpg.database.Clase
import com.example.proyectoclasessrpg.database.DBPr

class ProyectoSRPG: Application() {
    companion object {
        lateinit var database: DBPr
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, DBPr::class.java, "clase").build()
    }
}