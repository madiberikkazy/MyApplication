package com.example.myapplication.messages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMessagesBinding
import com.example.myapplication.databinding.FragmentProfileBinding

class MessagesFragment : Fragment(R.layout.fragment_messages) {

    private val binding: FragmentMessagesBinding by viewBinding(FragmentMessagesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.javaClass
    }
}
