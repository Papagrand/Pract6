package com.example.myapplication.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Controller
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.view.viewModel.FirstFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {

    //TODO СДЕЛАТЬ НОРМАЛЬНЫЙ BOTTOM NAVIGATION VIEW
    private lateinit var controller: Controller

    private val vm: FirstFragmentViewModel by viewModels()

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.e("AAA", "FFrag created")
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        controller = context as Controller
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val firstFragmentButton: Button = view.findViewById(R.id.firstFragmentButton)
//        firstFragmentButton.setOnClickListener {
//
//        }
//        val secondFragmentButton: Button = view.findViewById(R.id.secondFragmentButton)
//        secondFragmentButton.setOnClickListener {
//            controller.navigate(it)
//        }


        binding.saveValuesButton.setOnClickListener {

            val textWeight = binding.weightEditText.text.toString()
            val textHeight = binding.heightEditText.text.toString()
            val textAge = binding.ageEditText.text.toString()

            vm.save(textWeight, textHeight, textAge)

        }
        binding.firstFragmentButton.setOnClickListener {

        }
        binding.secondFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secFragment)
        }
        binding.foodFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_foodFragment)
        }

    }
}