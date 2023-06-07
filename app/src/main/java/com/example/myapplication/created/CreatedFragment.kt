package com.example.myapplication.created

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCreatedBinding
import com.example.myapplication.databinding.FragmentProfileBinding

class CreatedFragment : Fragment(R.layout.fragment_created) {

    private val binding: FragmentCreatedBinding by viewBinding(FragmentCreatedBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
    }
}