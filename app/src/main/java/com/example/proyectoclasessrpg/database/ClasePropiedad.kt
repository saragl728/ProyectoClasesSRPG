package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "claseTienePropiedades", foreignKeys = [ForeignKey(entity = Clase::class, parentColumns = ["nombreInterno"], childColumns = ["Clase"]),
    ForeignKey(entity = Propiedad::class, parentColumns = ["nombrePropiedad"], childColumns = ["Propiedad"])],
    primaryKeys = ["Clase", "Propiedad"])
class ClasePropiedad(
    var Clase: String = "",
    var Propiedad: String = "") {
}