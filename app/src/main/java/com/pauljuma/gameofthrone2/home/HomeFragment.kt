package com.pauljuma.gameofthrone2.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.gameofthrone2.MainActivity
import com.pauljuma.gameofthrone2.R
import com.pauljuma.gameofthrone2.thronesrecycleviews.CharacterAdapter
import com.pauljuma.gameofthrone2.thronesrecycleviews.ContinentsAdapter
import com.pauljuma.gameofthrone2.thronesrecycleviews.FamilyAdapter
import com.pauljuma.gameofthrone2.ui.ThronesViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }
    val continentsAdapter: ContinentsAdapter by lazy { ContinentsAdapter() }
    val familyAdapter: FamilyAdapter by lazy { FamilyAdapter() }
    lateinit var thronesViewModel: ThronesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        thronesViewModel = (activity as MainActivity).viewModel
        observeThrones()
        observeContinents()
        observeFamilies()

        view.apply {
            this.tvProfileName.text = getUserName()
            this.riProfile.text = getUserNameInitials(getUserName())
        }
        view.riProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_namePage)
        }

        return view

    }

    private fun observeThrones() {
        thronesViewModel.characters.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                characterAdapter.addItems(it)
                setUpCharacterRecycleView()
            }
        }
    }

    private fun observeContinents() {
        thronesViewModel.continents.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                continentsAdapter.addContinents(it)
                setUpContinentRecycleview()
            }
        }
    }

    private fun observeFamilies() {
        thronesViewModel.characters.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                familyAdapter.addFamilies(it)
                setUpPopularFamilyRecyleview()
            }
        }
    }

    private fun setUpCharacterRecycleView() {

        rvThronesCharacter.apply {
            hasFixedSize()
            adapter = characterAdapter
            layoutManager =
                LinearLayoutManager(
                    requireContext(), LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

    private fun setUpContinentRecycleview() {
        rvContinents.apply {
            hasFixedSize()
            adapter = continentsAdapter
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun setUpPopularFamilyRecyleview() {
        rvPopularFamilies.apply {
            hasFixedSize()
            adapter = familyAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )

        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun getUserName(): String {
        val pref: SharedPreferences = requireActivity().getSharedPreferences(
            getString(R.string.profile_name_key),
            Context.MODE_PRIVATE
        )

        return pref.getString(
            getString(R.string.profile_name_key),
            getString(R.string.defaultName)
        )!!
    }

    private fun getUserNameInitials(name: String): String {
        var firstName = name.split("\\s".toRegex()).first()[0]
        var secondName = name.split("\\s".toRegex()).getOrNull(1)

        return if (secondName != null) {
            secondName = secondName[0].toString()
            firstName.plus(secondName).uppercase()
        } else {
            firstName.plus(name.split("\\s".toRegex()).first()[1].toString()).uppercase()
        }

    }
}