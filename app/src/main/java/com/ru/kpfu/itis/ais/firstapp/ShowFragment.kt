package com.ru.kpfu.itis.ais.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.ru.kpfu.itis.ais.firstapp.databinding.FragmentShowBinding

class ShowFragment : Fragment(R.layout.fragment_show) {

    private var binding: FragmentShowBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowBinding.bind(view)

        val className = arguments?.getString("ARG")
        if (className != null) {
            Snackbar.make(view, className, Snackbar.LENGTH_LONG).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun createBundle(className: String): Bundle {
            val bundle = Bundle()
            bundle.putString("ARG", className)
            return bundle
        }

    }
}