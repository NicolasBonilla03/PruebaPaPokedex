package com.example.pruebapapokedex.network

import androidx.compose.ui.graphics.Path
import com.example.myapplicationwebservice.services.models.EvolutionChainResponse
import com.example.myapplicationwebservice.services.models.PokemonDetailsResponse
import com.example.myapplicationwebservice.services.models.PokemonListResponse
import com.example.myapplicationwebservice.services.models.PokemonTypeResponse
import com.example.myapplicationwebservice.services.models.RegionResponse
import retrofit2.Response
import retrofit2.http.GET

// ... (imports)

interface ApiService {

    // ... (endpoints existentes)

    @GET("region/")
    suspend fun getRegions(): Response<RegionResponse>

    @GET("pokedex/{regionName}/")
    suspend fun getPokemonByRegion(@Path("regionName") regionName: String): Response<PokemonListResponse>

    @GET("pokemon/{id}/")
    suspend fun getPokemonDetails(@Path("id") id: Int): Response<PokemonDetailsResponse>

    @GET("type/")
    suspend fun getPokemonTypes(): Response<PokemonTypeResponse>

    @GET("evolution-chain/{id}/")
    suspend fun getEvolutionChain(@Path("id") id: Int): Response<EvolutionChainResponse>
}