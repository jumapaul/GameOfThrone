package com.pauljuma.gameofthrone2.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.gameofthrone2.MainActivity
import com.pauljuma.gameofthrone2.R
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.characterrecycleview.CharacterAdapter
import com.pauljuma.gameofthrone2.dao.ThronesDatabase
import com.pauljuma.gameofthrone2.repository.ThronesRepository
import com.pauljuma.gameofthrone2.ui.ThronesCharacterViewModel
import com.pauljuma.gameofthrone2.util.Resource
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var characterAdapter: CharacterAdapter
    lateinit var characterViewModel: ThronesCharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        characterViewModel = (activity as MainActivity).viewModel

        setUpRecycleView()
        return view

    }

    private fun setUpRecycleView() {
        characterAdapter = CharacterAdapter()

        rvThronesCharacter.apply {
            adapter = characterAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}