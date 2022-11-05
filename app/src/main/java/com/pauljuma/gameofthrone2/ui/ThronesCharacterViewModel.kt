package com.pauljuma.gameofthrone2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.repository.ThronesRepository
import com.pauljuma.gameofthrone2.util.Resource
import com.pauljuma.gameofthrone2.util.Resource.*
import kotlinx.coroutines.launch

class ThronesCharacterViewModel(private var repository: ThronesRepository): ViewModel() {
    val characters: MutableLiveData<List<ThronesCharacterDataItem>> = MutableLiveData()

    init {
        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch {
        val response = repository.getCharacter()
        characters.value = response
    }

}