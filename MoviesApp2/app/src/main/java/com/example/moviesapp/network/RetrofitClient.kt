package com.example.moviesapp.network

import com.example.moviesapp.core.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

object RetrofitClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original: Request = chain.request()
            val request = original.newBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer ${Constants.API_KEY}")
                .build()
            chain.proceed(request)
        }
        .build()

    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WebService::class.java)
    }
}
