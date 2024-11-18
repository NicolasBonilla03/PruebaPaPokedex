package com.example.pokedex

import PokemonDriverAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationwebservice.R
import com.example.pokedex.components.ImageWeb
import com.example.pokedex.dataBases.viewsModels.PokemonViewModel


import com.example.pokedex.services.models.Region
import com.example.pokedex.ui.theme.MyApplicationWebServiceTheme

class MainActivity : ComponentActivity() {
    private val pokemonDriverAdapter by lazy { PokemonDriverAdapter() }
    val pokemonViewModel by lazy { PokemonViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var regions by remember { mutableStateOf(emptyList<Region>()) }
            var loadProducts by remember { mutableStateOf(false) }

            if (!loadProducts) {
                this.pokemonDriverAdapter.allRegions( // Llamar a allRegions directamente
                    loadData = { regionsList ->
                        regions = regionsList
                        loadProducts = true
                    },
                    errorData = {
                        println("Error en el servicio")
                        loadProducts = true
                    }
                )
            }
            ProductsScreen(regions = regions, onClickProduct = { goToDetail() })
        }
    }

    fun goToDetail() {
        val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun ProductsScreen(
    regions: List<Region>,
    onClickProduct: () -> Unit
) {
    MyApplicationWebServiceTheme {
        Scaffold(
            topBar = {
                Text(text = stringResource(id = R.string.title_products))
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LazyColumn {
                    items(
                        items = regions,
                        key = { it.name }
                    ) {
                        Column {
                            ImageWeb(url = it.url)

                            Row {
                                Text(text = stringResource(id = R.string.title))
                                Text(text = it.name)
                            }
                            Button(onClick = onClickProduct) {
                                Text(text = stringResource(id = R.string.title))
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 360)
@Composable
fun ProductsScreenPreview() {
    ProductsScreen(
        regions = emptyList(),
        onClickProduct = {}
    )
}