package com.example.android.helloworldviewmodelwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IndexViewModel @Inject constructor(
    private val service: NetworkModule.SampleService
) : ViewModel() {

    fun incrementCount() {
        service.incrementCount()
    }

    fun getCount(): LiveData<Int> {
        return service.getCount()
    }

}