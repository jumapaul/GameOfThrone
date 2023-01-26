package com.pauljuma.gameofthrone2.onboards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pauljuma.gameofthrone2.R
import kotlinx.android.synthetic.main.fragment_first_onboard.view.*
import kotlinx.android.synthetic.main.fragment_view_pager.*

class FirstOnboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_onboard, container, false)
        val viewPage = activity?.vpViewPager

        view.btnNext1.setOnClickListener {
            viewPage?.currentItem = 1
        }
        return view
    }
}