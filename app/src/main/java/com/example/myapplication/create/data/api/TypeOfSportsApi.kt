package com.example.myapplication.create.data.api

import com.example.myapplication.create.domain.model.TypeOfSports
import retrofit2.Response
import retrofit2.http.GET

interface TypeOfSportsApi {
    @GET("/todos")
    suspend fun getTodos(): Response<List<TypeOfSports>>
}
