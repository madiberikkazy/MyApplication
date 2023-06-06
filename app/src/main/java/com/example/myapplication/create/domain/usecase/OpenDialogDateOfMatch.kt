package com.example.myapplication.create.domain.usecase

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class OpenDialogDateOfMatch(private val onDateSelected: (Date) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDay)
            }.time

            onDateSelected.invoke(selectedDate)
        }, year, month, day)
    }
}
