package com.example.smarthome.data.repository

import com.example.smarthome.data.local.storage.RoomStorage
import com.example.smarthome.data.remote.storage.RetrofitStorage
import com.example.smarthome.data.utils.mapToCameraModel
import com.example.smarthome.data.utils.mapToDoorsModel
import com.example.smarthome.data.utils.mapToNote
import com.example.smarthome.domain.models.CameraModel
import com.example.smarthome.domain.models.DoorModel
import com.example.smarthome.domain.models.Product
import com.example.smarthome.domain.repository.RetrofitRepository
import com.example.smarthome.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RetrofitRepoImpl(
    private val retrofitStorage: RetrofitStorage,
    private val roomStorage: RoomStorage
) : RetrofitRepository {

    override suspend fun getCameras(): Flow<Resource<CameraModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = retrofitStorage.getCameras().mapToCameraModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override suspend fun getDoors(): Flow<Resource<DoorModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = retrofitStorage.getDoors().mapToDoorsModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override suspend fun getAllNotes(): Flow<Resource<List<Product>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = roomStorage.getAllNotes().mapToNote()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }


}