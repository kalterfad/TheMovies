package com.kalterfad.movietest.screens.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kalterfad.movietest.di.MainApp
import com.kalterfad.movietest.network.APIResponse
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun getMovies(offset: Int=0): MutableLiveData<APIResponse>{
        val mLiveData = MutableLiveData<APIResponse>()

        viewModelScope.launch {
            val response = MainApp.instance.appComponent.movie().getAllMovies(offset)

            if (response.isSuccessful) {
                mLiveData.postValue(response.body()!!)
            }
        }
        return mLiveData
    }
}
