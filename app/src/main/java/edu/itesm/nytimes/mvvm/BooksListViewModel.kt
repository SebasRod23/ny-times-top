package edu.itesm.nytimes.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.itesm.nytimes.data.Book
import edu.itesm.nytimes.response.BookResponse
import edu.itesm.nytimes.retrofit.RetrofitSingleton
import edu.itesm.nytimes.service.BookAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksListViewModel: ViewModel() {
    var liveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<Book>> {
        return liveData
    }

    fun booksAPICall() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitSingleton.getRetrofit().create(BookAPIService::class.java).getBooks()

            call.enqueue(object: Callback<BookResponse> {
                override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                    liveData.postValue(response.body()?.results?.books ?: emptyList())
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    liveData.postValue(emptyList())
                }
            })
        }
    }
}