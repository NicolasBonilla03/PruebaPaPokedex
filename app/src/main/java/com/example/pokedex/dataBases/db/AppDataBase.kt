package com.example.pokedex.dataBases.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.dataBases.daos.FavoritePokemonDao

import com.example.pokedex.dataBases.entities.FavoritePokemon


@Database(
    entities = [
        FavoritePokemon::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun FavoritoDao(): FavoritePokemonDao
}