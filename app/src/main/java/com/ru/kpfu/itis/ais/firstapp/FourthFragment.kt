package com.ru.kpfu.itis.ais.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ru.kpfu.itis.ais.firstapp.databinding.FragmentFourthBinding

class FourthFragment : Fragment(R.layout.fragment_fourth) {
    private var binding: FragmentFourthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFourthBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}