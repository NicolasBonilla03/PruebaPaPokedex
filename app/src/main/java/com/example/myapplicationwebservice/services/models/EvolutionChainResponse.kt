package com.example.myapplicationwebservice.services.models

data class EvolutionChainResponse(
    val id: Int,
    val chain: EvolutionChain
)

data class EvolutionChain(
    val species: PokemonSpecies,
    val evolves_to: List<EvolutionChain> // Lista de evoluciones
)

// PokemonSpecies se define igual que en PokemonDetailResponse