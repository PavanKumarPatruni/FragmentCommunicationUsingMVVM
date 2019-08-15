package com.pavankumarpatruni.mvvmfragmentdemo.repo

import androidx.lifecycle.MutableLiveData

class CounterRepository {

    companion object {
        private lateinit var counterRepository: CounterRepository

        fun getInstance(): CounterRepository {
            counterRepository = CounterRepository()
            return counterRepository
        }
    }

    fun getCounter(): MutableLiveData<Int> {
        val data = MutableLiveData<Int>()
        data.value = 0

        return data
    }

}