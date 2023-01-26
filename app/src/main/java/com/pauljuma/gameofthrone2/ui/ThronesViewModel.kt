package com.pauljuma.gameofthrone2.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.gameofthrone2.characterapi.data.ContinentsData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.repository.ThronesRepository
import kotlinx.coroutines.launch

class ThronesViewModel(private var repository: ThronesRepository) : ViewModel() {
    val characters: MutableLiveData<List<ThronesCharacterDataItem>> = MutableLiveData()
    val continents: MutableLiveData<List<ContinentsData>> = MutableLiveData()

    init {
        getCharacters()
        getContinents()
    }

    private fun getCharacters() = viewModelScope.launch {
        val response = repository.getCharacter()
        characters.value = response
    }

    private fun getContinents() = viewModelScope.launch {
        val response = repository.getContinents()
        continents.value = response
    }

}