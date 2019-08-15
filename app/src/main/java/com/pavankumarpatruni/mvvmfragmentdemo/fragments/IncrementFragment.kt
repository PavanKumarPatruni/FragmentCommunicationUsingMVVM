package com.pavankumarpatruni.mvvmfragmentdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pavankumarpatruni.mvvmfragmentdemo.R
import com.pavankumarpatruni.mvvmfragmentdemo.viewmodel.CounterViewModel
import kotlinx.android.synthetic.main.fragment_increment.view.*

class IncrementFragment : Fragment() {

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_increment, container, false)

        counterViewModel = activity?.run {
            ViewModelProviders.of(this).get(CounterViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        view.buttonIncrement.setOnClickListener {
            counterViewModel.incrementCounter()
        }

        return view
    }

}
