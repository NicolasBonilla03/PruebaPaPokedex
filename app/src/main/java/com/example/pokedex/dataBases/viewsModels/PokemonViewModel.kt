
package com.example.pokedex.dataBases.viewsModels


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationwebservice.dataBases.repositories.PokemonRepository
import com.example.pokedex.dataBases.ConexionDB
import com.example.pokedex.dataBases.entities.FavoritePokemon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(val context: Context) : ViewModel() {
    private val repository: PokemonRepository
    init {
        val db = ConexionDB.getDataBase(context)
        repository = PokemonRepository(db.FavoritoDao())
    }
    fun insert(pokemon: FavoritePokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(pokemon)
        }
    }
    fun delete(pokemon: FavoritePokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(pokemon)
        }
    }
    fun getAll(function: (Any?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAll()
        }
    }

}