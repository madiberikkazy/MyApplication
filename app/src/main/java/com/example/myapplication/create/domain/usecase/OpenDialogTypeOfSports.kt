package com.example.myapplication.create.domain.usecase

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.create.data.network.RetrofitInstance
import com.example.myapplication.create.domain.model.TypeOfSports
import com.example.myapplication.create.presentation.adapter.TypeOfSportsAdapter
import com.example.myapplication.databinding.DialogTypeOfSportsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class OpenDialogTypeOfSports : DialogFragment() {

    private lateinit var adapter: TypeOfSportsAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_type_of_sports, null)
        val binding = DialogTypeOfSportsBinding.bind(dialogView)

        setupRecyclerView(binding)

        binding.progressBar.isVisible = true

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = fetchDataFromApi()
                if (response != null) {
                    adapter.todos = response
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: IOException) {
                // Handle network error
            } catch (e: HttpException) {
                // Handle HTTP error
            } finally {
                binding.progressBar.isVisible = false
            }
        }

        builder.setView(dialogView)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }

    private suspend fun fetchDataFromApi(): List<TypeOfSports>? {
        return try {
            val response = RetrofitInstance.api.getTodos()
            if (response.isSuccessful && response.body() != null) {
                response.body()
            } else {
                null
            }
        } catch (e: IOException) {
            null
        } catch (e: HttpException) {
            null
        }
    }

    private fun setupRecyclerView(binding: DialogTypeOfSportsBinding) {
        adapter = TypeOfSportsAdapter()
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(requireContext())
    }
}
