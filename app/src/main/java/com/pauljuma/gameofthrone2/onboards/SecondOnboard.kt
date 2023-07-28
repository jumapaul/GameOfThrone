package com.pauljuma.gameofthrone2.onboards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pauljuma.gameofthrone2.R
import kotlinx.android.synthetic.main.fragment_second_onboard.view.*
import kotlinx.android.synthetic.main.fragment_view_pager.*

class SecondOnboard : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_onboard, container, false)

        val viewPage = activity?.vpViewPager

        view.btnNext2.setOnClickListener {
            viewPage?.currentItem = 2
        }

        return view
    }
}