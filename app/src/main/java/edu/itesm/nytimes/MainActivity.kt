package edu.itesm.nytimes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.itesm.nytimes.adapter.BooksAdapter
import edu.itesm.nytimes.data.Book
import edu.itesm.nytimes.databinding.ActivityMainBinding
import edu.itesm.nytimes.mvvm.BooksListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var myAdapter: BooksAdapter
    private lateinit var viewModel: BooksListViewModel

    private val booksList = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initAdapter()
        initViewModel()

        getBooksData()
    }

    private fun initAdapter() {
        myAdapter = BooksAdapter(booksList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(BooksListViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it.isNotEmpty()) {
                myAdapter.setBooks(it)
                myAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun getBooksData() {
        viewModel.booksAPICall()
    }
}