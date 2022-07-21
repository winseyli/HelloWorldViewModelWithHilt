package com.example.android.helloworldviewmodelwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityRetainedScoped
class SampleService @Inject constructor() {

    private val count = MutableLiveData<Int>(0)

    fun incrementCount() {
        count.value = count.value?.plus(1)
    }

    fun getCount(): LiveData<Int> {
        return count
    }
}