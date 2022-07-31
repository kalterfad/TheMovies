package com.kalterfad.movietest.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kalterfad.movietest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}