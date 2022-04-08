package edu.itesm.nytimes.response

import com.google.gson.annotations.SerializedName
import edu.itesm.nytimes.data.Books

data class BookResponse (@SerializedName("results") var results: Books?)
