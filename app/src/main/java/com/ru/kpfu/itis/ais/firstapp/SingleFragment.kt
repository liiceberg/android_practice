package com.ru.kpfu.itis.ais.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.ru.kpfu.itis.ais.firstapp.databinding.FragmentSingleBinding

class SingleFragment : Fragment(R.layout.fragment_single) {
    private var binding: FragmentSingleBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleBinding.bind(view)
        val book: Book? = findItem(arguments?.getInt(ID_KEY))
        if (book != null) {
            bindInstance(book, view)
        }
    }
    private fun findItem(id: Int?): Book? {
        BookRepository.list.forEach{
            if (it.id == id) {
                return it
            }
        }
        return null
    }

    private fun bindInstance(book: Book, view: View) {
        binding?.run {
            tvIdValue.text = book.id.toString()
            tvBookValue.text = book.name
            tvAuthorValue.text = book.author
            tvSummaryValue.text = book.summary

            Glide.with(view)
                .load(book.url)
                .placeholder(R.drawable.book)
                .error(R.drawable.image_not_found)
                .into(ivImg)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ID_KEY = "ID"
        fun createBundle(id: Int): Bundle {
            return bundleOf(ID_KEY to id)
        }

    }
}
