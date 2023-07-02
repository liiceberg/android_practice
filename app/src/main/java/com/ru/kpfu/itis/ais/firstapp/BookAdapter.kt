package com.ru.kpfu.itis.ais.firstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ru.kpfu.itis.ais.firstapp.databinding.ItemBookBinding

class BookAdapter(
    private var list: List<Book>,
    private val glide: RequestManager,
//    private val onItemClick: (Book) -> Unit,
) : RecyclerView.Adapter<BookItem>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookItem = BookItem(
        binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide
//        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: BookItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<Book>) {
        list = newList
        notifyDataSetChanged()
    }
}
