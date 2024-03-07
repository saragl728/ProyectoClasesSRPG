package com.example.proyectoclasessrpg.database

import androidx.room.Insert
import androidx.room.Query

interface Dao {
    @Query("SELECT * FROM clase")
    fun getAllClases(): MutableList<Clase>

    @Insert
    fun addClase(clase: Clase): Long
}