package com.example.android.helloworldviewmodelwithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helloworldviewmodelwithhilt.databinding.ActivitySecondBinding
import dagger.hilt.android.AndroidEntryPoint

// MainViewModel has @Inject constructor with parameters
// The only way to get the ViewModel instance is using @AndroidEntryPoint to work with injection
@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonOpen.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, SecondFragment.newInstance())
                .commit()
        }
    }
}