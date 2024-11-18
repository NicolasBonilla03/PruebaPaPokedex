package com.example.pokedex.services.driverAdapters

import com.example.pokedex.services.controllers.ProductsServices
import com.example.pokedex.services.models.Product

class ProductsDiverAdapter {
    private val service: ProductsServices = ProductsServices()

    fun allProducts(
        loadData: (list: List<Product>) -> Unit,
        errorData: () -> Unit
    ) {
        this.service.getAllProducts(
            success = { loadData(it) },
            error = { errorData() }
        )
    }
}