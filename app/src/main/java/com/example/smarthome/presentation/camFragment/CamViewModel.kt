package com.example.smarthome.presentation.camFragment

import com.example.smarthome.core.base.BaseViewModel
import com.example.smarthome.domain.models.CameraModel
import com.example.smarthome.domain.usecases.GetAllCamerasUseCase
import com.example.smarthome.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CamViewModel @Inject constructor(private val getCameras: GetAllCamerasUseCase) : BaseViewModel<CameraModel>() {

    private val _cameras = MutableStateFlow<UiState<List<CameraModel.Data.Camera>>>(UiState.Empty())
    val cameras: StateFlow<UiState<List<CameraModel.Data.Camera>>> = _cameras


    suspend fun getCameras() = doOperation(
        operation = { getCameras.executeRequest()}
    )

}