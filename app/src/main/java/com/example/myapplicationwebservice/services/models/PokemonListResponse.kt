package com.example.myapplicationwebservice.services.models

data class PokemonListResponse(
    val pokemon_entries: List<PokemonEntry>
    // ... (otros campos)
)

data class PokemonEntry(
    val entry_number: Int,
    val pokemon_species: PokemonSpecies
)

data class PokemonSpecies(
    val name: String,
    val url: String
)