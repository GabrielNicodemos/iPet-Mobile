package com.example.iPet.api

import com.example.iPet.model.PetshopModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServices {

    @GET("usuarios")
    fun getPetshops(): Call<List<PetshopModel>>


    companion object {
        var BASE_URL = "http://34.226.239.106:8080/"
        fun criar() : ApiServices {
            var retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiServices::class.java)
        }
    }
}