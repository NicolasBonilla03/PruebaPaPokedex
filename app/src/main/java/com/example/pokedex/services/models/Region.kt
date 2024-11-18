package com.example.pokedex.services.models

data class RegionResponse(
    val count: Int,
    val results: List<Region>
)

data class Region(
    val name: String,
    val url: String
)


