package com.example.proyectoclasessrpg.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "promocion", foreignKeys = [ForeignKey(entity = Clase::class, parentColumns = ["nombreInterno"], childColumns = ["claseBase"]),
    ForeignKey(entity =  Clase::class, parentColumns = ["nombreInterno"], childColumns = ["clasePromocionada"])], primaryKeys = ["claseBase", "clasePromocionada"])
data class Promocion(
    var claseBase: String = "",
    var clasePromocionada: String = ""
)
