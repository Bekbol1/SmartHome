package com.example.smarthome.core.di

import com.example.smarthome.domain.repository.RetrofitRepository
import com.example.smarthome.domain.usecases.GetAllCamerasUseCase
import com.example.smarthome.domain.usecases.GetAllDoorsUseCase
import com.example.smarthome.domain.usecases.GetAllProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetCameraUseCase(retrofitRepository: RetrofitRepository) =
        GetAllCamerasUseCase(retrofitRepository)

    @Provides
    fun provideGetDoorsUseCase(retrofitRepository: RetrofitRepository) =
        GetAllDoorsUseCase(retrofitRepository)

    @Provides
    fun provideGetAllProductsUseCase(retrofitRepository: RetrofitRepository) =
        GetAllProductsUseCase(retrofitRepository)

}