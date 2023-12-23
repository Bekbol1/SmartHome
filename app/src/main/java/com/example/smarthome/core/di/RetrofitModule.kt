package com.example.smarthome.core.di

import com.example.smarthome.data.local.storage.RoomStorage
import com.example.smarthome.data.remote.network.ApiService
import com.example.smarthome.data.remote.network.RetrofitClient
import com.example.smarthome.data.remote.storage.RetrofitStorage
import com.example.smarthome.data.remote.storage.RetrofitStorageImpl
import com.example.smarthome.data.repository.RetrofitRepoImpl
import com.example.smarthome.domain.repository.RetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideApiService(retrofitClient: RetrofitClient) = retrofitClient.createApiService()

    @Provides
    @Singleton
    fun provideRetrofitStorage(apiService: ApiService) : RetrofitStorage = RetrofitStorageImpl(apiService)

    @Provides
    @Singleton
    fun provideRetrofitRepo(retrofitStorage: RetrofitStorage,roomStorage: RoomStorage): RetrofitRepository = RetrofitRepoImpl(retrofitStorage,roomStorage)

}