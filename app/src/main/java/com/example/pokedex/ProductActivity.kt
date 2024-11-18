package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.myapplicationwebservice.R
import com.example.pokedex.dataBases.entities.FavoritePokemon
import com.example.pokedex.dataBases.viewsModels.PokemonViewModel
import com.example.pokedex.ui.theme.MyApplicationWebServiceTheme

class ProductActivity : ComponentActivity() {
    private val pokemonViewModel by lazy { PokemonViewModel(this) }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...

        setContent {
            var favoritePokemon by remember { mutableStateOf<List<FavoritePokemon>>(emptyList()) }

            LaunchedEffect(Unit) {
                pokemonViewModel.getAll { favoritePokemonList ->
                    favoritePokemon = favoritePokemonList as List<FavoritePokemon>
                }
            }

            MyApplicationWebServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        items(
                            items = favoritePokemon,
                            key = { it.id }
                        ) { pokemon ->
                            Card(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Image(painter = painterResource(id = R.drawable.person_24px),
                                    contentDescription = null)
                                Text(text = pokemon.name)
                            }
                        }
                    }
                }
            }
        }
    }
}