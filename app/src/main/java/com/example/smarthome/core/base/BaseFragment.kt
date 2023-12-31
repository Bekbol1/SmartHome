package com.example.smarthome.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.smarthome.R


abstract class BaseFragment<VB:ViewBinding> : Fragment() {
    private var _binding:VB? = null
    protected val binding get() = _binding!!
    abstract fun inflateViewBinding():VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = inflateViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initRecyclerView()
    }
    open fun initView(){}
    open fun initRecyclerView(){}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}