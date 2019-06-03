package com.example.kriz.basketballapp.Room.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kriz.basketballapp.Room.Entities.Partido

@Dao
interface PartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido : Partido)

    @Query("SELECT * FROM Partido")
    fun getAllMatches(): LiveData<List<Partido>>

    @Query("UPDATE Partido SET P_ganador = :equipo WHERE P_fecha=:fecha")
    fun setWinner(fecha:String,equipo:String)

    @Query("UPDATE Partido SET P_puntosA = :puntos WHERE P_fecha=:fecha")
    fun setPointsA(fecha:String,puntos:Int)

    @Query("UPDATE Partido SET P_puntosB = :puntos WHERE P_fecha=:fecha")
    fun setPointsB(fecha:String,puntos:Int)

}