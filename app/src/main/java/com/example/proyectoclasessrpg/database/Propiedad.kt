package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "propiedad")
data class Propiedad(
    @PrimaryKey
    var nombrePropiedad: String
)
