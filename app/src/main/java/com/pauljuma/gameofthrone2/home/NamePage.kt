package com.pauljuma.gameofthrone2.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pauljuma.gameofthrone2.R
import kotlinx.android.synthetic.main.fragment_name_page.view.*

class NamePage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_name_page, container, false)

        val name = view.etName
        val pref = requireActivity().getSharedPreferences(getString(R.string.profile_name_key),
            Context.MODE_PRIVATE)

        name.setText(
            pref.getString(
                getString(R.string.profile_name_key),
                getString(R.string.defaultName)
            )
        )

        view.btnSave.setOnClickListener {
            pref.edit().putString(getString(R.string.profile_name_key), name.text?.trim()
                .toString()).apply()

            findNavController().navigate(R.id.action_namePage_to_homeFragment)

        }

        return view
    }
}