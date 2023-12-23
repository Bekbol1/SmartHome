package com.example.smarthome.domain.usecases

import com.example.smarthome.domain.repository.RetrofitRepository

class GetAllProductsUseCase (private val retrofitRepository: RetrofitRepository) {

    suspend fun executeRequest() = retrofitRepository.getAllNotes()
}