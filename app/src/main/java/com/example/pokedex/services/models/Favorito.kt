package com.example.pokedex.services.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_pokemons")
data class FavoritePokemon(
    @PrimaryKey val id: Int,    // ID único del pokémon
    val name: String,           // Nombre del pokémon
    val type: String,           // Tipo principal del pokémon
    val region: String,         // Región del pokémon
    val imageUrl: String        // URL de la imagen
)
