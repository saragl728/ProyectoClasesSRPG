package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arma")
data class Arma(
    @PrimaryKey
    var NombreArma: String
)
