package com.example.android.helloworldviewmodelwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: SampleService
) : ViewModel() {

    fun incrementCount() {
        service.incrementCount()
    }

    fun getCount(): LiveData<Int> {
        return service.getCount()
    }

}

@Singleton
class SampleService @Inject constructor() {

    private val count = MutableLiveData<Int>(0)

    fun incrementCount() {
        count.value = count.value?.plus(1)
    }

    fun getCount(): LiveData<Int> {
        return count
    }
}