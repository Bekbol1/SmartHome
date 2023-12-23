package com.example.smarthome.data.local.storage

import com.example.smarthome.data.local.storage.models.ProductDTO

interface RoomStorage {
    suspend fun getAllNotes():List<ProductDTO>

}