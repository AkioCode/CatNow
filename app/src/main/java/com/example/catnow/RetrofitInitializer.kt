package com.example.catnow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.thecatapi.com/v1/")
        .build()

    fun catService() = retrofit.create(CatService::class.java)!!
}