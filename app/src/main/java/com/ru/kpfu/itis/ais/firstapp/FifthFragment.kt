package com.ru.kpfu.itis.ais.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ru.kpfu.itis.ais.firstapp.databinding.FragmentFifthBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {

    private var binding: FragmentFifthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFifthBinding.bind(view)

        binding?.run {
            clickButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_fifthFragment_to_showFragment,
                    ShowFragment.createBundle(javaClass.name)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}