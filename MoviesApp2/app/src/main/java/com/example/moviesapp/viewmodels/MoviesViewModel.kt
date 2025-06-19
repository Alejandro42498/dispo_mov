package com.example.moviesapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.Constants
import com.example.moviesapp.models.MovieModel
import com.example.moviesapp.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Log

class MoviesViewModel : ViewModel() {

    private val _moviesList = MutableLiveData<List<MovieModel>>()
    val moviesList: LiveData<List<MovieModel>> = _moviesList

    fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getAllMovies(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                val results = response.body()?.results
                if (response.isSuccessful && results != null) {
                    _moviesList.value = results.sortedBy { it.title }
                } else {
                    Log.e("MoviesViewModel", "Error in getAllMovies: ${response.code()}")
                    _moviesList.value = emptyList()
                }
            }
        }
    }

    fun getPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getAllMovies(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                val results = response.body()?.results
                if (response.isSuccessful && results != null) {
                    _moviesList.value = results.sortedByDescending { it.popularity.toFloat() }
                } else {
                    Log.e("MoviesViewModel", "Error in getPopular: ${response.code()}")
                    _moviesList.value = emptyList()
                }
            }
        }
    }

    fun getTopRate() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getAllMovies(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                val results = response.body()?.results
                if (response.isSuccessful && results != null) {
                    _moviesList.value = results.sortedByDescending { it.rating.toFloat() }
                } else {
                    Log.e("MoviesViewModel", "Error in getTopRate: ${response.code()}")
                    _moviesList.value = emptyList()
                }
            }
        }
    }

    fun getUpcoming() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getAllMovies(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                val results = response.body()?.results
                if (response.isSuccessful && results != null) {
                    _moviesList.value = results.sortedBy { it.title }
                } else {
                    Log.e("MoviesViewModel", "Error in getUpcoming: ${response.code()}")
                    _moviesList.value = emptyList()
                }
            }
        }
    }
}
