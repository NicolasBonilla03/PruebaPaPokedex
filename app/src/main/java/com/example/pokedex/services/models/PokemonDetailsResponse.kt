package com.example.pokedex.services.models

data class PokemonDetailsResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeSlot>,
    val sprites: Sprites,
    val species: PokemonSpecies,
    // ... otros campos como stats, abilities, moves, etc.
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)

data class Sprites(
    val front_default: String?,
    val front_shiny: String?,
    // ... otros sprites
)
