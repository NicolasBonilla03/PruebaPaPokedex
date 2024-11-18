package com.example.myapplicationwebservice.services.models

data class Region(
    val name: String,
    val url: String
)

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonType>,
    val sprites: Sprites,
    // ... (otros campos)
)



data class Evolution(
    val name: String,
    val id: Int,
    val url: String
)