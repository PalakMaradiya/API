package com.example.api.`interface`

import com.example.api.response.ResponseItem

import retrofit2.http.GET

interface Intreface {

    @GET("todos")
    suspend fun getProduct() : List<ResponseItem>
}