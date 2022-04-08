package edu.itesm.nytimes.service

import edu.itesm.nytimes.response.BookResponse
import retrofit2.Call
import retrofit2.http.GET

interface BookAPIService {
    @GET("hardcover-fiction.json?api-key=O4PHxyABiAtGUWveGOtBubujcQx0X9b5")
    fun getBooks(): Call<BookResponse>
}