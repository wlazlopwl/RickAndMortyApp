package com.appdevpwl.rickyandmortyapp.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appdevpwl.rickyandmortyapp.databinding.ItemCharactersFooterStateBinding

class CharactersLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<CharactersLoadStateAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        val binding = ItemCharactersFooterStateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }


    inner class ViewHolder(private val binding: ItemCharactersFooterStateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.charactersStateButtonRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {


            binding.apply {

                if (loadState is LoadState.Error){
                    charactersStateTextviewError.text = loadState.error.localizedMessage
                }
                charactersStateProgressBar.isVisible = loadState is LoadState.Loading
                charactersStateButtonRetry.isVisible = loadState !is LoadState.Loading
                charactersStateTextviewError.isVisible = loadState !is LoadState.Loading
            }

        }
    }
}