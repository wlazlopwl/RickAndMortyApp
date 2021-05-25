package com.appdevpwl.rickyandmortyapp.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.appdevpwl.rickyandmortyapp.data.characters.Result
import com.appdevpwl.rickyandmortyapp.databinding.ItemCharacterRecyclerviewBinding

class CharactersAdapter :
    PagingDataAdapter<Result, CharactersAdapter.CharactersViewHolder>(CharacterDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemCharacterRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharactersViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    class CharactersViewHolder(private val binding: ItemCharacterRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result) {
            binding.apply {
                characterItem = item

            }
        }
    }
}


class CharacterDiffCallback : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}


