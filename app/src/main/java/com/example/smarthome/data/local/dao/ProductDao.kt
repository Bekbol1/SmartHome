package com.example.smarthome.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.smarthome.data.local.storage.models.ProductDTO

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllNotes():List<ProductDTO>

    @Query("SELECT * FROM products WHERE tittle ==:title")
    fun getAllNotesByTitle(title:String):List<ProductDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(productDTO: ProductDTO)

    @Insert
    fun insertAllNotes(productDTOS: List<ProductDTO>)

    @Update
    fun updateNote(productDTO: ProductDTO)

    @Delete
    fun deleteNote(productDTO: ProductDTO)
}