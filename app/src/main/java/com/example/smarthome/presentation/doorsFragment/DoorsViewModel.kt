package com.example.smarthome.presentation.doorsFragment

import com.example.smarthome.core.base.BaseViewModel
import com.example.smarthome.domain.models.DoorModel
import com.example.smarthome.domain.usecases.GetAllDoorsUseCase
import com.example.smarthome.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(private val getAllDoors: GetAllDoorsUseCase):
    BaseViewModel<DoorModel>() {
    private val _doors = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Empty())
    val doors: StateFlow<UiState<List<DoorModel>>> = _doors

    suspend fun getDoors() = doOperation(
        operation = { getAllDoors.executeRequest() }
    )
}