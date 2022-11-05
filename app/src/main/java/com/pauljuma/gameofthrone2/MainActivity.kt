package com.pauljuma.gameofthrone2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.gameofthrone2.dao.ThronesDatabase
import com.pauljuma.gameofthrone2.repository.ThronesRepository
import com.pauljuma.gameofthrone2.ui.ThronesCharacterViewModel
import com.pauljuma.gameofthrone2.ui.ThronesCharacterViewModelFactoryProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ThronesCharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GameOfThrone2)
        setContentView(R.layout.activity_main)

        val characterRepository = ThronesRepository(ThronesDatabase(this))
        val thronesViewModelFactory = ThronesCharacterViewModelFactoryProvider(characterRepository)
        viewModel = ViewModelProvider(
            this,
            thronesViewModelFactory
        ).get(ThronesCharacterViewModel::class.java)

        supportActionBar?.hide()
    }

}