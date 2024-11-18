import com.example.pokedex.services.models.PokemonEntry

data class PokedexResponse(
    val pokemon_entries: List<PokemonEntry>
)



data class PokemonSpecies(
    val name: String,
    val url: String
)
