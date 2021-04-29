package com.appdevpwl.rickyandmortyapp.ui.locations

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

class LocationsFragment : DaggerFragment() {

    private lateinit var locationsViewModel: LocationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        locationsViewModel =
                ViewModelProvider(this).get(LocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_locations, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        locationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}