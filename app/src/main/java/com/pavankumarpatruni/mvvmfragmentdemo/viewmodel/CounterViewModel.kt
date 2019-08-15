package com.pavankumarpatruni.mvvmfragmentdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavankumarpatruni.mvvmfragmentdemo.repo.CounterRepository

class CounterViewModel : ViewModel() {

    private var counter: MutableLiveData<Int> = MutableLiveData()

    fun getCounter(): LiveData<Int> {
        counter = CounterRepository.getInstance().getCounter()
        return counter
    }

    fun incrementCounter() {
        val count = counter.value

        var localValue = 0
        if (count != null) {
            localValue = count
            localValue++
        } else {
            localValue = 1
        }

        counter.value = localValue
    }

}