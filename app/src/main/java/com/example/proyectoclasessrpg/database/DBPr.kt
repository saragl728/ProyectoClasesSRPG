package com.example.proyectoclasessrpg.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Clase::class), version = 1)
abstract class DBPr : RoomDatabase(){
abstract fun listaCla(): Dao
}