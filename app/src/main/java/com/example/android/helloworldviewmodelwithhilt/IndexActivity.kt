package com.example.android.helloworldviewmodelwithhilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.helloworldviewmodelwithhilt.databinding.ActivityIndexBinding

class IndexActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIndexBinding.inflate(layoutInflater).apply {
            buttonMainActivity.setOnClickListener {
                val intent = Intent(this@IndexActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        val view = binding.root
        setContentView(view)
    }
}