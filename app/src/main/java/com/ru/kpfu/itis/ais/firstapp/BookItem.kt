package com.ru.kpfu.itis.ais.firstapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ru.kpfu.itis.ais.firstapp.databinding.ItemBookBinding

class BookItem(
    private val binding: ItemBookBinding,
    private val glide: RequestManager,
//    private val onItemClick: (Book) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)

    private val context: Context
        get() = itemView.context

    fun onBind(book: Book) {
        binding.run {
            tvTitle.text = book.name
            tvAuthor.text = book.author


            glide
                .load(book.url)
                .placeholder(R.drawable.book)
                .error(R.drawable.image_not_found)
                .apply(options)
                .into(ivImg)

//            root.setOnClickListener {
//                onItemClick(book)
//            }
//            tvTitle.setTextColor(context.getColor(city.color))
        }
    }
}
