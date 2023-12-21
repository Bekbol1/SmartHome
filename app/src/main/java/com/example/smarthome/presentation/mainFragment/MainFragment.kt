package com.example.smarthome.presentation.mainFragment

import android.os.Bundle
import android.view.View
import com.example.smarthome.core.base.BaseFragment
import com.example.smarthome.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun inflateViewBinding():FragmentMainBinding =
        FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
    }

    private fun initTabLayout() {
        binding.viewPager.adapter = VPAdapter(this)
        TabLayoutMediator(binding.tabLayoutMain,binding.viewPager){tab,position->
            when(position){
                0 -> tab.text = "Камеры"
                1 -> tab.text = "Двери"
            }
        }.attach()

    }

}