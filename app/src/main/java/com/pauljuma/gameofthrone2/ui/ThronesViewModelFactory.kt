package com.pauljuma.gameofthrone2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.gameofthrone2.repository.ThronesRepository

class ThronesCharacterViewModelFactoryProvider(val thronesRepository: ThronesRepository) :
    ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ThronesViewModel(thronesRepository) as T
    }
}