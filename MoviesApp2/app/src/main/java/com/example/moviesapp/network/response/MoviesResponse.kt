package com.example.moviesapp.network.response

import com.example.moviesapp.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @SerializedName ("results")
    val results: List<MovieModel>,

)
