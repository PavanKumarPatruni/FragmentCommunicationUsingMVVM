package com.pavankumarpatruni.mvvmfragmentdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pavankumarpatruni.mvvmfragmentdemo.R
import com.pavankumarpatruni.mvvmfragmentdemo.viewmodel.CounterViewModel
import kotlinx.android.synthetic.main.fragment_show.view.*

class ShowFragment : Fragment() {

    private var textViewCounter: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_show, container, false)

        textViewCounter = view.textViewCounter
        textViewCounter?.let {
            it.text = "0"
        }

        val counterViewModel = activity?.run {
            ViewModelProviders.of(this).get(CounterViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        counterViewModel.getCounter().observe(this, Observer { value ->

            textViewCounter?.let {
                it.text = value.toString()
            }
        })

        return view
    }

}
