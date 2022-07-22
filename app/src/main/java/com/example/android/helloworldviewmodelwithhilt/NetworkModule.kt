package com.example.android.helloworldviewmodelwithhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    class SampleService @Inject constructor() {

        private val count = MutableLiveData<Int>(0)

        fun incrementCount() {
            count.value = count.value?.plus(1)
        }

        fun getCount(): LiveData<Int> {
            return count
        }
    }

}