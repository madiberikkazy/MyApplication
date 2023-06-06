package com.example.myapplication.create.domain.usecase

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class OpenDialogTimeOfMatch(private val onTimeSelected: (Date) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                val selectedTime = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, selectedHour)
                    set(Calendar.MINUTE, selectedMinute)
                }.time

                onTimeSelected.invoke(selectedTime)
            },
            hour,
            minute,
            false
        )
    }
}
