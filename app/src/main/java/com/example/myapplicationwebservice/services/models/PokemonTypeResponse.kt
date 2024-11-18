package com.example.myapplicationwebservice.services.models

data class PokemonTypeResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonTypeResult>
)

data class PokemonTypeResult(
    val name: String,
    val url: String
)