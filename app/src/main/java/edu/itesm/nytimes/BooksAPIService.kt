package edu.itesm.nytimes

import retrofit2.Response
import retrofit2.http.GET


interface APIService {
    @GET("hardcover-fiction.json?api-key=O4PHxyABiAtGUWveGOtBubujcQx0X9b5")
    suspend fun getBooks() : Response<Results>
}