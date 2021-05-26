package com.appdevpwl.rickyandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.appdevpwl.rickyandmortyapp.R
import com.appdevpwl.rickyandmortyapp.databinding.FragmentCharactersBinding
import com.appdevpwl.rickyandmortyapp.ui.characters.adapter.CharactersAdapter
import com.appdevpwl.rickyandmortyapp.ui.characters.adapter.CharactersLoadStateAdapter
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    private lateinit var charactersViewModel: CharactersViewModel

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        charactersViewModel =
            ViewModelProviders.of(this, viewModelProvider).get(CharactersViewModel::class.java)

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val characterAdapter = CharactersAdapter()

        binding.apply {
            charactersRecyclerview.layoutManager = LinearLayoutManager(context)
            charactersRecyclerview.setHasFixedSize(true)
            charactersRecyclerview.adapter = characterAdapter.withLoadStateHeaderAndFooter(
                header = CharactersLoadStateAdapter{characterAdapter.retry()},
                footer = CharactersLoadStateAdapter{characterAdapter.retry()},
            )


        }


        lifecycleScope.launch {
            charactersViewModel.flow.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}