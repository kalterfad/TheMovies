package com.kalterfad.movietest.screens.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kalterfad.movietest.R
import com.kalterfad.movietest.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: SplashScreenFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(SplashScreenFragmentViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}