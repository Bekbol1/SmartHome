package com.example.smarthome.domain.usecases

import com.example.smarthome.domain.repository.RetrofitRepository

class GetAllDoorsUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun executeRequest() = retrofitRepository.getDoors()
}