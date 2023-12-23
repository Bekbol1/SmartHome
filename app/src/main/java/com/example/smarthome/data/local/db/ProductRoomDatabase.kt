package com.example.smarthome.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smarthome.data.local.dao.ProductDao
import com.example.smarthome.data.local.storage.models.ProductDTO

@Database(entities = [ProductDTO::class],version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {

    abstract fun getDao(): ProductDao

}