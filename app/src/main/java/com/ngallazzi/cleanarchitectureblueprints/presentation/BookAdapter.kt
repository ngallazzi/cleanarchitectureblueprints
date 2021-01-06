package com.ngallazzi.cleanarchitectureblueprints.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngallazzi.cleanarchitectureblueprints.R
import com.ngallazzi.cleanarchitectureblueprints.entities.BookWithStatus
import com.ngallazzi.cleanarchitectureblueprints.entities.BookmarkStatus


class BookAdapter(
    private val context: Context,
    private val listener: ActionClickListener
) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val books: ArrayList<BookWithStatus> = arrayListOf()

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
        books[position].also { book ->
            book.imageUrl?.let { imageUrl ->
                Glide.with(context)
                    .load(imageUrl)
                    .into(holder.ivBookCover)
                holder.tvBookName.text = ""
                holder.tvBookAuthors.text = ""
            } ?: kotlin.run {
                Glide.with(context)
                    .load(R.drawable.ic_launcher_background)
                    .into(holder.ivBookCover)
                holder.tvBookName.text = book.title
                holder.tvBookAuthors.text = book.authors.joinToString()
            }

            holder.ivUnbookmark.setOnClickListener {
                listener.unbookmark(book)
            }

            holder.ivBookmark.setOnClickListener {
                listener.bookmark(book)
            }

            when (book.status) {
                BookmarkStatus.BOOKMARKED -> {
                    holder.ivBookmark.visibility = View.GONE
                    holder.ivUnbookmark.visibility = View.VISIBLE
                }
                BookmarkStatus.UNBOOKMARKED -> {
                    holder.ivBookmark.visibility = View.VISIBLE
                    holder.ivUnbookmark.visibility = View.GONE
                }
            }
        }
    }

    fun submitUpdate(update: List<BookWithStatus>) {
        val callback = BooksDiffCallback(books, update)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(callback)

        books.clear()
        books.addAll(update)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvBookName: TextView = view.findViewById(R.id.tvBookName)
        val tvBookAuthors: TextView = view.findViewById(R.id.tvBookAuthors)
        val ivBookCover: ImageView = view.findViewById(R.id.ivBookCover)
        val ivBookmark: ImageView = view.findViewById(R.id.ivBookmark)
        val ivUnbookmark: ImageView = view.findViewById(R.id.ivUnbookmark)
    }

    class BooksDiffCallback(
        private val oldBooks: List<BookWithStatus>,
        private val newBooks: List<BookWithStatus>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldBooks.size
        }

        override fun getNewListSize(): Int {
            return newBooks.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldBooks[oldItemPosition].id == newBooks[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldBooks[oldItemPosition].status == newBooks[newItemPosition].status
        }
    }

    interface ActionClickListener {
        fun bookmark(book: BookWithStatus)
        fun unbookmark(book: BookWithStatus)
    }
}