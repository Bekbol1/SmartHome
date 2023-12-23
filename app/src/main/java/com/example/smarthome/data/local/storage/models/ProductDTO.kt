package com.example.smarthome.data.local.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "products")
data class ProductDTO(
    @PrimaryKey (autoGenerate = true)
    val id: Long? = null,
    val tittle: String? = null,
    val description: String? = null,
    val isDone: Boolean = false
)
