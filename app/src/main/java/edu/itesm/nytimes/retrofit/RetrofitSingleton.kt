package edu.itesm.nytimes.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}