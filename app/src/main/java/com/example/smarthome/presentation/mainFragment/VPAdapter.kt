package com.example.smarthome.presentation.mainFragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smarthome.presentation.camFragment.CamFragment
import com.example.smarthome.presentation.doorsFragment.DoorsFragment

class VPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int  = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CamFragment()
            else -> DoorsFragment()
        }
    }
}