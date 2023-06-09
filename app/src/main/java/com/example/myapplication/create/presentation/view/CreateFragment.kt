package com.example.myapplication.create.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.create.domain.usecase.OpenDialogAddressOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogDateOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTimeOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTypeOfSports
import com.example.myapplication.create.presentation.viewmodel.CreateViewModel
import com.example.myapplication.databinding.FragmentCreateBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CreateFragment : Fragment(R.layout.fragment_create) {

    private val binding: FragmentCreateBinding by viewBinding(FragmentCreateBinding::bind)
    private lateinit var viewModel: CreateViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewBinding()
        viewModel = ViewModelProvider(this).get(CreateViewModel::class.java)
    }

    private fun setupViewBinding() = with(binding) {
        textViewAddress.setOnClickListener {
            val dialog = OpenDialogAddressOfMatch(textViewAddress)
            dialog.show(parentFragmentManager, "MyDialog")
        }

        textViewDate.setOnClickListener {
            showDatePickerDialog()
        }

        textViewTime.setOnClickListener {
            showTimePickerDialog()
        }

        btnTypeOfSports.setOnClickListener {
            val dialog = OpenDialogTypeOfSports()
            dialog.show(parentFragmentManager, "MyDialog")
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = OpenDialogDateOfMatch { selectedDate ->
            viewLifecycleOwner.lifecycleScope.launch {
                updateSelectedDate(selectedDate)
            }
        }
        datePickerDialog.show(parentFragmentManager, "DatePickerDialog")
    }

    private fun updateSelectedDate(date: Date) {
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
        binding.textViewDate.text = formattedDate
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = OpenDialogTimeOfMatch { selectedTime ->
            viewLifecycleOwner.lifecycleScope.launch {
                updateSelectedTime(selectedTime)
            }
        }
        timePickerDialog.show(parentFragmentManager, "TimePickerDialog")
    }

    private fun updateSelectedTime(time: Date) {
        val formattedTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(time)
        binding.textViewTime.text = formattedTime
    }
}
