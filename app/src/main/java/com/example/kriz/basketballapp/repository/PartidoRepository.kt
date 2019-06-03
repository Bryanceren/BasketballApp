package com.example.room_library.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.kriz.basketballapp.Room.Daos.PartidoDao
import com.example.kriz.basketballapp.Room.Entities.Partido


class PartidoRepository(private val partidoDao: PartidoDao) {

    val allMatches : LiveData<List<Partido>> = partidoDao.getAllMatches()

    @WorkerThread
    suspend fun insertMatch(partido: Partido){
        partidoDao.insert(partido)
    }

    fun setPointsA(fecha:String,puntos:Int){
        partidoDao.setPointsA(fecha,puntos)
    }
    fun setPointsB(fecha: String,puntos:Int){
        partidoDao.setPointsB(fecha,puntos)
    }
    fun setWinner(fecha:String,equipo:String){
        partidoDao.setWinner(fecha,equipo)
    }

}