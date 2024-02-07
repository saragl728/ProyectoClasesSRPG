package com.example.proyectoclasessrpg.database
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "clase")
data class Clase(
    @PrimaryKey
    var nombreInterno:String = "",
    var nombre:String = "",
    var descripcion:String = "",
    var movimiento:Int = 0
)
