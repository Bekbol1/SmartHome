package com.example.smarthome.domain.repository

import com.example.smarthome.domain.models.CameraModel
import com.example.smarthome.domain.models.DoorModel
import com.example.smarthome.domain.models.Product
import com.example.smarthome.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RetrofitRepository {
    suspend fun getCameras(): Flow<Resource<CameraModel>>
    suspend fun getDoors():Flow<Resource<DoorModel>>
    suspend fun getAllNotes():Flow<Resource<List<Product>>>
}