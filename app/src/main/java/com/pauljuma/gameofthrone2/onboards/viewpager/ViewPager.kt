package com.pauljuma.gameofthrone2.onboards.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import com.pauljuma.gameofthrone2.R
import com.pauljuma.gameofthrone2.onboards.FirstOnboard
import com.pauljuma.gameofthrone2.onboards.SecondOnboard
import com.pauljuma.gameofthrone2.onboards.ThirdOnboard
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPager : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val firstOnboard = FirstOnboard()
        val secondOnboard = SecondOnboard()
        val thirdOnboard = ThirdOnboard()

        val fragmentList = arrayListOf(firstOnboard, secondOnboard, thirdOnboard)

        val pagerAdapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        view.vpViewPager.adapter = pagerAdapter

        return view
    }


}