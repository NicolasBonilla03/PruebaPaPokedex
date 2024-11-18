package com.example.pokedex.services.controllers
import ApiClient
import ApiService
import androidx.lifecycle.viewModelScope
import com.example.pokedex.services.models.Region
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegionService: ApiClient() {
    private val serviceScope = CoroutineScope(Job() + Dispatchers.IO)

    fun getAllRegions(
        success: (regions: List<Region>) -> Unit,
        error: () -> Unit
    ) {
        serviceScope.launch(Dispatchers.IO) {
            try {
                val response = getRetrofit()
                    .create(ApiService::class.java)
                    .getAllRegions()
                val data = response.body()
                when (data) {
                    null -> success(emptyList())
                    else -> success(listOf(data))
                }
            } catch (e: Exception) {
                println(e)
                error()
            }
        }
    }
}
