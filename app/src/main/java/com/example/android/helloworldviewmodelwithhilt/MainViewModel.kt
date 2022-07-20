package com.example.android.helloworldviewmodelwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val count = MutableLiveData<Int>(0)

    fun incrementCount() {
        count.value = count.value?.plus(1)
    }

    fun getCount(): LiveData<Int> {
        return count
    }

}