package com.example.proyectoclasessrpg.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.proyectoclasessrpg.ProyectoSrpg

@Dao
interface Dao {

    //clase
    @Query("SELECT * FROM clase")
    suspend fun getAllClases(): MutableList<Clase>

    @Query("SELECT * FROM clase WHERE nombreInterno LIKE :clase")
    suspend fun getClasesPorNombre(clase: String): MutableList<Clase>

    @Upsert(entity = Clase::class)
    suspend fun addClase(clase: Clase): Long

    @Transaction
    suspend fun borraClase(clase: Clase){
        val promosA = getPromosHaciaPromo(clase.nombreInterno)
        val promosB = getPromosDeBase(clase.nombreInterno)
        val armasC = getArmaPorClase(clase.nombreInterno)
        val PropC = getPropiedadPorClase(clase.nombreInterno)
        val habiliC = getHabilidadPorClase(clase.nombreInterno)

        //procedo al borrado
        for (i in 0 until promosA.size){
                    ProyectoSrpg.database.listaCla().deletePromocion(promosA[i])
        }
        for (i in 0 until promosB.size){
            ProyectoSrpg.database.listaCla().deletePromocion(promosB[i])
        }
        for (i in 0 until armasC.size){
            ProyectoSrpg.database.listaCla().deleteClaseConArma(armasC[i])
        }

        for (i in 0 until PropC.size){
            ProyectoSrpg.database.listaCla().deleteClaseConPropiedad(PropC[i])
        }

        for (i in 0 until habiliC.size){
            ProyectoSrpg.database.listaCla().deleteClaseConHabilidad(habiliC[i])
        }

        deleteClase(clase)
    }

    @Delete(entity = Clase::class)
    suspend fun deleteClase(clase: Clase) : Int

    //habilidad
    @Query("SELECT * FROM habilidad")
    suspend fun getAllHabilidades(): MutableList<Habilidad>

    @Query("SELECT * FROM habilidad WHERE nombreHabilidad LIKE :habilidad")
    suspend fun getHabilidadPorNombre(habilidad: String): MutableList<Habilidad>

    @Upsert(entity = Habilidad::class)
    suspend fun addHabilidad(habilidad: Habilidad): Long

    @Transaction
    suspend fun borraHabilidad(habilidad: Habilidad){
        val hab = getClasePorHabilidad(habilidad.nombreHabilidad)
        for (i in 0 until hab.size){
            ProyectoSrpg.database.listaCla().deleteClaseConHabilidad(hab[i])
        }
        deleteHabilidad(habilidad)
    }

    @Delete(entity = Habilidad::class)
    suspend fun deleteHabilidad(habilidad: Habilidad): Int


    //propiedad
    @Query("SELECT * FROM propiedad")
    suspend fun getAllPropiedades(): MutableList<Propiedad>

    @Query("SELECT * FROM propiedad WHERE nombrePropiedad LIKE :propiedad")
    suspend fun getPropiedadPorNombre(propiedad: String): MutableList<Propiedad>

    @Insert(entity = Propiedad::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPropiedad(propiedad: Propiedad): Long

    @Transaction
    suspend fun borraPropiedad(propiedad: Propiedad){
        val prop = getClasePorPropiedad(propiedad.nombrePropiedad)
        for (i in 0 until prop.size){
            ProyectoSrpg.database.listaCla().deleteClaseConPropiedad(prop[i])
        }
        deletePropiedad(propiedad)
    }

    @Delete(entity = Propiedad::class)
    suspend fun deletePropiedad(propiedad: Propiedad): Int

    //arma
    @Query("SELECT * FROM arma")
    suspend fun getAllArmas(): MutableList<Arma>

    @Query("SELECT * FROM arma WHERE NombreArma LIKE :nom")
    suspend fun getArmasConNombre(nom: String): MutableList<Arma>

    @Insert(entity = Arma::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArma(arma: Arma): Long

    @Transaction
    suspend fun borraArma(arma: Arma){
        val arm = getClasePorArma(arma.NombreArma)
        for (i in 0 until arm.size){
            ProyectoSrpg.database.listaCla().deleteClaseConArma(arm[i])
        }
        deleteArma(arma)
    }

    @Delete(entity = Arma::class)
    suspend fun deleteArma(arma: Arma): Int

    //promoción
    @Query("SELECT * FROM promocion")
    suspend fun getAllPromociones(): MutableList<Promocion>

    @Query("SELECT * FROM promocion WHERE claseBase = :claBase")
    suspend fun getPromosDeBase(claBase: String): MutableList<Promocion>

    @Query("SELECT * FROM promocion WHERE clasePromocionada = :claPromo")
    suspend fun getPromosHaciaPromo(claPromo: String): MutableList<Promocion>

    @Insert(entity = Promocion::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPromocion(promocion: Promocion): Long

    @Delete(entity = Promocion::class)
    suspend fun deletePromocion(promocion: Promocion): Int

    //clase+Arma
    @Query("SELECT * FROM claseUsaArma")
    suspend fun getClasesConArmas() : MutableList<ClaseArma>

    @Query("SELECT * FROM claseUsaArma WHERE nomArma = :arma")
    suspend fun getClasePorArma(arma: String): MutableList<ClaseArma>

    @Query("SELECT * FROM claseUsaArma WHERE nomClase = :clase")
    suspend fun getArmaPorClase(clase: String): MutableList<ClaseArma>

    @Insert(entity = ClaseArma::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addClaseConArma(claseArma: ClaseArma): Long

    @Delete(entity = ClaseArma::class)
    suspend fun deleteClaseConArma(claseArma: ClaseArma): Int

    //clase + habilidad
    @Query("SELECT * FROM claseTieneHabilidades")
    suspend fun getClasesConHabilidades() : MutableList<ClaseHabilidad>

    @Query("SELECT * FROM claseTieneHabilidades WHERE Habilidad = :habilidad")
    suspend fun getClasePorHabilidad(habilidad: String): MutableList<ClaseHabilidad>

    @Query("SELECT * FROM claseTieneHabilidades WHERE Clase = :clase")
    suspend fun getHabilidadPorClase(clase: String): MutableList<ClaseHabilidad>

    @Insert(entity = ClaseHabilidad::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addClaseConHabilidad(claseHabilidad: ClaseHabilidad): Long

    @Delete(entity = ClaseHabilidad::class)
    suspend fun deleteClaseConHabilidad(claseHabilidad: ClaseHabilidad): Int

    //clase + propiedad
    @Query("SELECT * FROM claseTienePropiedades")
    suspend fun getClasesConPropiedades() : MutableList<ClasePropiedad>

    @Query("SELECT * FROM claseTienePropiedades WHERE Propiedad = :prop")
    suspend fun getClasePorPropiedad(prop: String): MutableList<ClasePropiedad>

    @Query("SELECT * FROM claseTienePropiedades WHERE Clase = :clase")
    suspend fun getPropiedadPorClase(clase: String): MutableList<ClasePropiedad>

    @Insert(entity = ClasePropiedad::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addClaseConPropiedad(clasePropiedad: ClasePropiedad): Long

    @Delete(entity = ClasePropiedad::class)
    suspend fun deleteClaseConPropiedad(clasePropiedad: ClasePropiedad): Int

}