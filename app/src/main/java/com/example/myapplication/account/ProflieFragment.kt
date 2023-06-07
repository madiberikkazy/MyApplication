package com.example.myapplication.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.databinding.FragmentProfileBinding

class ProflieFragment : Fragment() {

    private val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
    }
}