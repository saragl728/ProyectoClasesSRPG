package com.example.proyectoclasessrpg.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habilidad")
data class Habilidad(
    @PrimaryKey
    var nombreHabilidad:String = "",
    var descripcion:String = ""
)
