package com.kalterfad.movietest.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kalterfad.movietest.R
import com.kalterfad.movietest.databinding.FragmentSplashScreenBinding
import com.kalterfad.movietest.utils.APP_ACTIVITY


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                APP_ACTIVITY.navController.navigate(R.id.action_splashScreenFragment_to_homeFragment)
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}