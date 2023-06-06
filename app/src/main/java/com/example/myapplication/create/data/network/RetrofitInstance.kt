package com.example.myapplication.create.data.network

import com.example.myapplication.create.data.api.TypeOfSportsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: TypeOfSportsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypeOfSportsApi::class.java)
    }
}