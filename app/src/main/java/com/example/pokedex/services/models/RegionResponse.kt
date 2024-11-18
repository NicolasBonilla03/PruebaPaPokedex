package com.example.pokedex.services.models

data class RegionResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<RegionResult>
)

data class RegionResult(
    val name: String,
    val url: String
)