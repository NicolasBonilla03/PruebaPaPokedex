package com.example.pokedex.dataBases

import android.content.Context
import androidx.room.Room
import com.example.pokedex.dataBases.db.AppDataBase

class ConexionDB {
    companion object {
        @Volatile
        private var instanceDb: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            if (instanceDb === null) {
                synchronized(this) {
                    instanceDb = buildDB(context)
                }
            }
            return instanceDb!!
        }

        private fun buildDB(context: Context): AppDataBase {
            val dataBase = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "Pokemones_Favoritos"
            )
            return  dataBase.build()
        }
    }
}