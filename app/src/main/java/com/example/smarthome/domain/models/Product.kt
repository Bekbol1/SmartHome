package com.example.smarthome.domain.models

data class Product(
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val isDone:Boolean = false
)
