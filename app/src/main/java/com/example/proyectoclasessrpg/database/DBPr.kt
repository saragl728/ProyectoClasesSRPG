package com.example.proyectoclasessrpg.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Clase::class, Arma::class, Habilidad::class, Propiedad::class, Promocion::class, ClasePropiedad::class, ClaseHabilidad::class, ClaseArma::class], version = 1, exportSchema = false)
abstract class DBPr : RoomDatabase(){
abstract fun listaCla(): Dao

companion object {
    @Volatile
    private var Instance: DBPr? = null

    @Synchronized
    fun getInstance(contexto: Context): DBPr {
        var instance = Instance
        if (instance == null){
            instance = Room.databaseBuilder(contexto.applicationContext, DBPr::class.java, "claseSRPG_db")
                .fallbackToDestructiveMigration()
                .build()
        }
        return instance

    }
}
}