package com.pauljuma.gameofthrone2.home

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
        view.btnSave.setOnClickListener {
            findNavController().navigate(R.id.action_namePage_to_homeFragment)
        }
        return view
    }
}