package com.example.myapplication.create.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.create.domain.usecase.OpenDialogAddressOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogDateOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTimeOfMatch
import com.example.myapplication.create.domain.usecase.OpenDialogTypeOfSports
import kotlinx.coroutines.launch

class CreateViewModel(
    private val openDialogTimeOfMatch: OpenDialogTimeOfMatch,
    private val openDialogDateOfMatch: OpenDialogDateOfMatch,
    private val openDialogAddressOfMatch: OpenDialogAddressOfMatch,
    private val openDialogTypeOfSports: OpenDialogTypeOfSports
) : ViewModel() {
    // Add any necessary functions and logic for the CreateViewModel here
}
