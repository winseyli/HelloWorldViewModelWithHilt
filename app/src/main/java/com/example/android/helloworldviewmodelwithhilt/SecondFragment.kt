package com.example.android.helloworldviewmodelwithhilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.android.helloworldviewmodelwithhilt.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    // View Binding
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val viewModel: SecondViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonIncrement.setOnClickListener {
            viewModel.incrementCount()
        }

        binding.buttonClose.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .remove(this)
                .commit()
        }

        viewModel.getCount().observe(viewLifecycleOwner, Observer<Int>{ count ->
            // update UI
            binding.textViewFirst.text = "In the fragment, count: $count"
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}