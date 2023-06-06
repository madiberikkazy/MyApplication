package com.example.myapplication.create.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.create.domain.model.TypeOfSports
import com.example.myapplication.databinding.ItemTypeOfSportsBinding

class TypeOfSportsAdapter : RecyclerView.Adapter<TypeOfSportsAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTypeOfSportsBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TypeOfSports>() {
        override fun areItemsTheSame(oldItem: TypeOfSports, newItem: TypeOfSports): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TypeOfSports, newItem: TypeOfSports): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<TypeOfSports>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTypeOfSportsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
            tvTitle.text = todo.title
            cbDone.isChecked = todo.completed
        }
    }
}