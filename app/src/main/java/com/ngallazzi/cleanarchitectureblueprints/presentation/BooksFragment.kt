package com.ngallazzi.cleanarchitectureblueprints.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ngallazzi.cleanarchitectureblueprints.R
import com.ngallazzi.cleanarchitectureblueprints.CleanArchitectureBlueprintsApplication
import com.ngallazzi.cleanarchitectureblueprints.LayoutUtils
import com.ngallazzi.cleanarchitectureblueprints.entities.BookWithStatus
import com.ngallazzi.domain.entities.Volume
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment : Fragment() {
    private lateinit var booksAdapter: BookAdapter

    private val booksViewModel: BooksViewModel by viewModels {
        BooksViewModel.BooksViewModelFactory(
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).getBooksUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).getBookmarksUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).bookmarkBooksUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).unbookmarkBookUseCase,
            ((requireActivity().application) as CleanArchitectureBlueprintsApplication).bookWithStatusMapper,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        booksAdapter = BookAdapter(requireContext(), object : BookAdapter.ActionClickListener {
            override fun bookmark(book: BookWithStatus) {
                booksViewModel.bookmark(book)
            }

            override fun unbookmark(book: BookWithStatus) {
                booksViewModel.unbookmark(book)
            }
        })

        booksViewModel.getBooks("Robert C. Martin")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        booksViewModel.books.observe(viewLifecycleOwner, {
            booksAdapter.submitUpdate(it)
        })

        booksViewModel.dataLoading.observe(viewLifecycleOwner, { loading ->
            when (loading) {
                true -> LayoutUtils.crossFade(pbLoading, rvBooks)
                false -> LayoutUtils.crossFade(rvBooks, pbLoading)
            }
        })

        rvBooks.apply {
            layoutManager =
                GridLayoutManager(requireContext(), COLUMNS_COUNT)
            adapter = booksAdapter
        }

        booksViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(
                requireContext(),
                getString(R.string.an_error_has_occurred, it),
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    companion object {
        const val COLUMNS_COUNT = 2
    }
}