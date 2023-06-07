package com.example.myapplication.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentListsBinding

class ListsFragment : Fragment(R.layout.fragment_lists) {

    private val binding: FragmentListsBinding by viewBinding(FragmentListsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
    }
}
