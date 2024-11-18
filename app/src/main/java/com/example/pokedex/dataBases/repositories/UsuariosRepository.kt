package com.example.pokedex.dataBases.repositories

import com.example.pokedex.dataBases.daos.UsuariosDao
import com.example.pokedex.dataBases.entities.UsuarioEntity
import kotlinx.coroutines.flow.Flow

class UsuariosRepository(private val dao: UsuariosDao) {
    fun getAll(): Flow<List<UsuarioEntity>> {
        return this.dao.getAll()
    }

    fun find(id: Int): Flow<UsuarioEntity> {
        return this.dao.find(id)
    }

    suspend fun save(usuario:UsuarioEntity){
        return this.dao.save(usuario)
    }
}