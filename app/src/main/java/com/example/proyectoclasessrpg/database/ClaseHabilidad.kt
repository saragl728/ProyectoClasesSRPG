package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "claseTieneHabilidades", foreignKeys = [ForeignKey(entity = Clase::class, parentColumns = ["nombreInterno"], childColumns = ["Clase"]),
    ForeignKey(entity = Habilidad::class, parentColumns = ["nombreHabilidad"], childColumns = ["Habilidad"])],
    primaryKeys = ["Clase", "Habilidad"])
data class ClaseHabilidad(
    var Clase: String = "",
    var Habilidad: String = ""
)
