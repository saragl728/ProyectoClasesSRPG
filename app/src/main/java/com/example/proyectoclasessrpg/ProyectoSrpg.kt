package com.example.proyectoclasessrpg

import android.app.Application
import com.example.proyectoclasessrpg.database.DBPr

class ProyectoSrpg: Application() {
    companion object {
        lateinit var database: DBPr
    }

    override fun onCreate() {
        super.onCreate()
        database = DBPr.getInstance(this)
    }
}