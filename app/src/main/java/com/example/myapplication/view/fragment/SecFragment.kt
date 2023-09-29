package com.example.myapplication.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSecBinding
import com.example.myapplication.view.viewModel.SecondFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecFragment : Fragment() {
    private var _binding: FragmentSecBinding? = null
    private val binding get() = _binding!!
    private val vm: SecondFragmentViewModel by viewModels<SecondFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val firstFragmentButton: Button = view.findViewById(R.id.firstFragmentButton)
//        firstFragmentButton.setOnClickListener {
//            controller.navigate(it)
//        }
//        val secondFragmentButton: Button = view.findViewById(R.id.secondFragmentButton)
//        secondFragmentButton.setOnClickListener {
//
//        }

        //TODO ПОМЕНЯТЬ НАЗВАНИЕ МЕТОДУ GET
        val result = vm.get()
        binding.weightTextView.text = result.weight
        binding.heightTextView.text = result.height
        binding.ageTextView.text = result.age





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}