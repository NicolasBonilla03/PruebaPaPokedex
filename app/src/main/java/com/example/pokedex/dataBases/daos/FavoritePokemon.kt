package com.example.pokedex.dataBases.daos

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.pokedex.dataBases.entities.FavoritePokemon


@Dao
interface FavoritePokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: FavoritePokemon)

    @Delete
    suspend fun delete(pokemon: FavoritePokemon)

    @Query("SELECT * FROM favorite_pokemons")
    suspend fun getAllFavorites(): List<FavoritePokemon>
}

@Database(entities = [FavoritePokemon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritePokemonDao(): FavoritePokemonDao
}

