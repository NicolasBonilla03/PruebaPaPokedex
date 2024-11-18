package com.example.pokedex.services.controllers

import androidx.lifecycle.viewModelScope
import com.example.pokedex.services.models.Pokemon
import com.example.pruebapapokedex.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsServices : BaseService() {

    fun getRegion(
        success: (regions: List<Pokemon>) -> Unit,
        error: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getRetrofit()
                    .create(ApiService::class.java)
                    .getRegions()
                val data = response.body()
                when (data) {
                    null -> success(emptyList())
                    else -> success(data)
                }
            } catch (e: Exception) {
                println(e)
                error()
            }
        }
    }
}