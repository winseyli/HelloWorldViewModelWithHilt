package com.example.android.helloworldviewmodelwithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android.helloworldviewmodelwithhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// MainViewModel has @Inject constructor with parameters
// The only way to get the ViewModel instance is using @AndroidEntryPoint to work with injection
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // Activity or a fragment that is annotated with @AndroidEntryPoint can get
    // the ViewModel instance as normal using ViewModelProvider or
    // the by viewModels() KTX extensions:
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonIncrement.setOnClickListener {
            viewModel.incrementCount()
        }

        viewModel.getCount().observe(this, Observer<Int>{ count ->
            // update UI
            binding.textViewFirst.text = "Count: $count"
        })
    }
}