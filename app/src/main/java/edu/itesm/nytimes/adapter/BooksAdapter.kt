package edu.itesm.nytimes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.itesm.nytimes.R
import edu.itesm.nytimes.data.Book

class BooksAdapter(private var data: List<Book>?) : RecyclerView.Adapter<BooksAdapter.ViewHolder>()  {
    fun setBooks(books: List<Book>) {
        data = books
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bind(property: Book){
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            val description = view.findViewById<TextView>(R.id.tvDescription)

            title.text = property.title
            description.text = property.description

            Glide.with(view.context)
                .load(property.book_image)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_ny_book, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data!![position])
    }
}
