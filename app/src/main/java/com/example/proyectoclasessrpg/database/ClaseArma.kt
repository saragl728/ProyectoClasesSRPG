package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "claseUsaArma", foreignKeys = [ForeignKey(entity = Clase::class, parentColumns = ["nombreInterno"], childColumns = ["nomClase"]),
    ForeignKey(entity = Arma::class, parentColumns = ["NombreArma"], childColumns = ["nomArma"])],
    primaryKeys = ["nomClase", "nomArma"])
data class ClaseArma(
    var nomClase: String = "",
    var nomArma: String = ""
)
