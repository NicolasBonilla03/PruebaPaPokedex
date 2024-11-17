package com.example.myapplicationwebservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationwebservice.dataBases.entities.UsuarioEntity
import com.example.myapplicationwebservice.dataBases.viewsModels.UsuaiosViewModel
import com.example.myapplicationwebservice.ui.theme.MyApplicationWebServiceTheme

class ProductActivity : ComponentActivity() {
    private val usuariosViewModel by lazy { UsuaiosViewModel(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var usuarios by remember{
                mutableStateOf<List<UsuarioEntity>>(emptyList())
            }

            this.usuariosViewModel.loadUsers{ usuarios = it}
            MyApplicationWebServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    LazyColumn {
                        items(
                            items = usuarios,
                            key = { it.id }
                        ){
                            val usuario = it
                            Card(
                                modifier = Modifier.padding(8.dp)
                            ){
                                Image(painter = painterResource(id = R.drawable.person_24px),
                                    contentDescription = null)
                                Text(text = usuario.name)
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationWebServiceTheme {
        Greeting("Android")
    }
}