package com.example.smarthome.data.remote.storage

import com.example.smarthome.data.remote.network.ApiService
import com.example.smarthome.data.remote.storage.models.CameraModelDTO
import com.example.smarthome.data.remote.storage.models.DoorModelDTO


class RetrofitStorageImpl(private val apiService: ApiService): RetrofitStorage {
    override suspend fun getCameras(): CameraModelDTO {
        val apiBody = apiService.getCameras().body()
        return CameraModelDTO(apiBody!!.data,apiBody.success)
    }

    override suspend fun getDoors(): DoorModelDTO {
        val apiBody = apiService.getDoors().body()
        return DoorModelDTO(apiBody!!.data,apiBody.success)
    }
}