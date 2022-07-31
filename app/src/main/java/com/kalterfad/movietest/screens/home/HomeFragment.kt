package com.kalterfad.movietest.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.kalterfad.movietest.databinding.FragmentHomeBinding
import com.kalterfad.movietest.network.Movie

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: HomeFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mHomeAdapter: HomeAdapter

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
        mViewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]

        mViewModel.getMovies().observe(this) {
            mHomeAdapter = HomeAdapter(it.results as MutableList<Movie>, mViewModel::getMovies)
            mRecyclerView = mBinding.movieRecyclerView
            mRecyclerView.adapter = mHomeAdapter

            mBinding.shimmer.apply {
                stopShimmer()
                visibility = View.INVISIBLE
            }
            mBinding.movieRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}