package com.ru.kpfu.itis.ais.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.ru.kpfu.itis.ais.firstapp.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null
    private var adapter: BookAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = BookAdapter(
            list = BookRepository.list,
            glide = Glide.with(this),
            onItemClick = {
                findNavController()
                    .navigate(
                        R.id.action_mainFragment_to_singleFragment,
                        SingleFragment.createBundle(it.id)
                    )
            })
        binding?.rvBook?.adapter = adapter
    }

}
