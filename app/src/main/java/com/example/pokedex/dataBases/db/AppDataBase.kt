package com.example.pokedex.dataBases.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.dataBases.daos.UsuariosDao
import com.example.pokedex.dataBases.entities.UsuarioEntity

@Database(
    entities = [
        UsuarioEntity::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuariosDao(): UsuariosDao
}