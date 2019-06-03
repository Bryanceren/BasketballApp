package com.example.room_library.room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kriz.basketballapp.Room.Daos.PartidoDao
import com.example.kriz.basketballapp.Room.Entities.Partido


@Database(entities = [Partido::class], version = 3, exportSchema = false)
public abstract class LibraryDB: RoomDatabase(){

    abstract fun partidoDao():PartidoDao

    companion object {
        @Volatile
        private var INSTANCE:LibraryDB? = null

        fun getInstance(Appcontext: Context): LibraryDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(Appcontext,LibraryDB::class.java,"Library_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

}