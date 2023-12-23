package com.example.smarthome.data.remote.storage

import com.example.smarthome.data.remote.storage.models.CameraModelDTO
import com.example.smarthome.data.remote.storage.models.DoorModelDTO

interface RetrofitStorage {

    suspend fun getCameras(): CameraModelDTO

    suspend fun getDoors(): DoorModelDTO
}