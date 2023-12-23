package com.example.smarthome.core.di

import android.content.Context
import androidx.room.Room
import com.example.smarthome.data.local.dao.ProductDao
import com.example.smarthome.data.local.db.ProductRoomDatabase
import com.example.smarthome.data.local.storage.RoomStorage
import com.example.smarthome.data.local.storage.RoomStorageImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = ProductRoomDatabase::class.java,
        name = "notes"
    ).build()

    @Provides
    fun provideProductDao(database: ProductRoomDatabase) = database.getDao()

    @Provides
    fun provideRoomStorage(noteDao: ProductDao): RoomStorage = RoomStorageImpl(noteDao)
}