package com.ngallazzi.cleanarchitectureblueprints.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngallazzi.cleanarchitectureblueprints.R
import com.ngallazzi.domain.entities.Volume


class BookAdapter(private val context: Context) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val books: ArrayList<Volume> = arrayListOf()

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_book,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        books[position].run {
            this.volumeInfo.imageUrl?.let {
                Glide.with(context)
                    .load(this.volumeInfo.imageUrl)
                    .into(holder.ivBookCover)
            } ?: kotlin.run {
                holder.tvBookName.text = this.volumeInfo.title
                holder.tvBookAuthors.text = this.volumeInfo.authors.joinToString()
            }
        }
    }

    fun submitUpdate(update: List<Volume>) {
        books.clear()
        books.addAll(update)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvBookName: TextView = view.findViewById(R.id.tvBookName)
        val tvBookAuthors: TextView = view.findViewById(R.id.tvBookAuthors)
        val ivBookCover: ImageView = view.findViewById(R.id.ivBookCover)
    }
}