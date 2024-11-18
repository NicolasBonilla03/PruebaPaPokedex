package com.example.myapplicationwebservice.services.endpoints

import com.example.myapplicationwebservice.services.models.Pokemon

class PokemonDao {

    suspend fun insert(pokemon: Pokemon) {

    }

    fun delete(pokemon: Pokemon) {
        // ... (lógica para eliminar un Pokémon de la caché)


    }
    fun getAll(): List<Pokemon> {
        // ... (lógica para obtener todos los Pokémon de la caché)
        return emptyList()
    }

}
