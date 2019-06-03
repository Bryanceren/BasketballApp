package com.example.room_library.Models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kriz.basketballapp.Room.Entities.Partido
import com.example.room_library.repository.PartidoRepository
import com.example.room_library.room.Database.LibraryDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (app: Application): AndroidViewModel(app){
    private val repository : PartidoRepository
    val allMatches : LiveData<List<Partido>>


    init {
        val partidoDao = LibraryDB.getInstance(app).partidoDao()
        repository = PartidoRepository(partidoDao)
        allMatches = repository.allMatches
    }

    fun insertMarches (partido: Partido) = viewModelScope.launch(Dispatchers.IO){
        repository.insertMatch(partido)
    }
    fun setPointsA (fecha:String,puntos:Int) = viewModelScope.launch(Dispatchers.IO){
        repository.setPointsA(fecha,puntos)
    }
    fun setPointsB (fecha:String,puntos:Int) = viewModelScope.launch(Dispatchers.IO){
        repository.setPointsB(fecha,puntos)
    }
    fun setWinner (fecha:String,equipo:String) = viewModelScope.launch(Dispatchers.IO){
        repository.setWinner(fecha,equipo)
    }
}