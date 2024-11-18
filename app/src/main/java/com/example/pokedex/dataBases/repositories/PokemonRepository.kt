package com.example.myapplicationwebservice.dataBases.repositories


import com.example.pokedex.dataBases.daos.FavoritePokemonDao
import com.example.pokedex.dataBases.entities.FavoritePokemon
import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val dao: FavoritePokemonDao) {
    suspend fun insert(pokemon: FavoritePokemon) {
        dao.insert(pokemon)
    }

    suspend fun delete(pokemon: FavoritePokemon) {
        dao.delete(pokemon)
    }

    suspend fun getAll(): List<FavoritePokemon> {
        return dao.getAllFavorites()

    }
}