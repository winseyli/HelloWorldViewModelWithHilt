package com.example.android.helloworldviewmodelwithhilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android.helloworldviewmodelwithhilt.databinding.ActivityIndexBinding
import dagger.hilt.android.AndroidEntryPoint

// IndexViewModel has @Inject constructor with parameters
// The only way to get the ViewModel instance is using @AndroidEntryPoint to work with injection
@AndroidEntryPoint
class IndexActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityIndexBinding

    // Activity or a fragment that is annotated with @AndroidEntryPoint can get
    // the ViewModel instance as normal using ViewModelProvider or
    // the by viewModels() KTX extensions:
    private val viewModel by viewModels<IndexViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIndexBinding.inflate(layoutInflater).apply {
            buttonMainActivity.setOnClickListener {
                val intent = Intent(this@IndexActivity, MainActivity::class.java)
                startActivity(intent)
            }

            buttonSecondActivity.setOnClickListener {
                val intent = Intent(this@IndexActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
        val view = binding.root
        setContentView(view)

        viewModel.getCount().observe(this, Observer<Int>{ count ->
            // update UI
            binding.textViewCount.text = "Count: $count"
        })
    }
}