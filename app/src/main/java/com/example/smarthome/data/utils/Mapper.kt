package com.example.smarthome.data.utils

import com.example.smarthome.data.local.storage.models.ProductDTO
import com.example.smarthome.data.remote.storage.models.CameraModelDTO
import com.example.smarthome.data.remote.storage.models.DoorModelDTO
import com.example.smarthome.domain.models.CameraModel
import com.example.smarthome.domain.models.DoorModel
import com.example.smarthome.domain.models.Product

fun CameraModelDTO.mapToCameraModel(): CameraModel {
    val camerasModelDataCameras = mutableListOf<CameraModel.Data.Camera>()
    this.data.cameras.mapTo(camerasModelDataCameras){
        CameraModel.Data.Camera(it.favorites,it.id, it.name, it.rec, it.room?:"", it.snapshot)
    }
    val camerasModelData = CameraModel.Data(camerasModelDataCameras.toList(),this.data.room)
    return CameraModel(camerasModelData,this.success)
}

fun DoorModelDTO.mapToDoorsModel(): DoorModel {
    val doorsModelData = mutableListOf<DoorModel.Data>()
    this.data.mapTo(doorsModelData) {
        DoorModel.Data(it.favorites, it.id, it.name, it.room?:"", it.snapshot)
    }
    return DoorModel(doorsModelData, this.success)
}

fun List<ProductDTO>.mapToNote():List<Product> = this.map{
    Product(
        id = it.id,
        title = it.tittle,
        description = it.description,
        isDone = it.isDone
    )
}

fun Product.mapToNoteDTO():ProductDTO = ProductDTO(
    id = this.id,
    tittle = this.title,
    description = this.description,
    isDone = this.isDone
)