package com.appdevpwl.rickyandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.appdevpwl.rickyandmortyapp.R
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CharactersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    private lateinit var charactersViewModel: CharactersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        charactersViewModel =
            ViewModelProviders.of(this, viewModelProvider).get(CharactersViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_characters, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}