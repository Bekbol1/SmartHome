package com.example.smarthome.data.local.storage

import com.example.smarthome.data.local.dao.ProductDao
import com.example.smarthome.data.local.storage.models.ProductDTO

class RoomStorageImpl(private val dao: ProductDao):RoomStorage {
    override suspend fun getAllNotes(): List<ProductDTO> = dao.getAllNotes()
}