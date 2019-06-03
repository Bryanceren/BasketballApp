package com.example.kriz.basketballapp.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Partido")
data class Partido(
    @ColumnInfo(name = "P_EquipoA") var EquipoA : String,
    @ColumnInfo(name = "P_EquipoB") var EquipoB : String,
    @ColumnInfo(name = "P_puntosA") var puntosA : Int=0,
    @ColumnInfo(name = "P_puntosB") var puntosB : Int=0,
    @ColumnInfo(name = "P_fecha") var fecha : String,
    @ColumnInfo(name = "P_ganador") var ganador : String=""
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}