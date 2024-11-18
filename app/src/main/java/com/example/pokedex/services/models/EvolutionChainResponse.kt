package com.example.pokedex.services.models

data class EvolutionChainResponse(
    val id: Int,
    val chain: EvolutionChain
)

data class EvolutionChain(
    val species: PokemonSpecies,
    val evolves_to: List<EvolutionChain>,
    val evolvesTo: List<Evolution>
) {

}

// PokemonSpecies se define igual que en PokemonDetailResponse