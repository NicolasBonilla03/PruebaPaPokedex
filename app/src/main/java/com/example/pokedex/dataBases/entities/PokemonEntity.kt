package com.example.pokedex.dataBases.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_pokemons")
data class FavoritePokemon(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val region: String,
    val imageUrl: String
)
