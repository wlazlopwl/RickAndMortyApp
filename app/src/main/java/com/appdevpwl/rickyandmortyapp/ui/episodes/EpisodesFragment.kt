package com.appdevpwl.rickyandmortyapp.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appdevpwl.rickyandmortyapp.R
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

class EpisodesFragment : DaggerFragment() {

    private lateinit var episodesViewModel: EpisodesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        episodesViewModel =
                ViewModelProvider(this).get(EpisodesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_episodes, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        episodesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}