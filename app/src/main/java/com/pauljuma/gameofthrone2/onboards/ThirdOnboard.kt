package com.pauljuma.gameofthrone2.onboards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pauljuma.gameofthrone2.R
import kotlinx.android.synthetic.main.fragment_third_onboard.view.*
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ThirdOnboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_onboard, container, false)

        view.btnNext3.setOnClickListener {

            findNavController().navigate(R.id.action_viewPager_to_namePage)

            onBoardFinished()
        }

        return view
    }

   private fun onBoardFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",
            Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}