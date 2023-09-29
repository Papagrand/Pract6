package com.example.myapplication.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFoodBinding
import com.example.myapplication.view.FoodFragmentAdapter
import com.example.myapplication.view.viewModel.FoodFragmentViewModel
//import com.example.myapplication.view.viewModelFactory.FoodFragmentViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class FoodFragment : Fragment() {
    //TODO СДЕЛАТЬ НОРМАЛЬНЫЙ BOTTOM NAVIGATION VIEW
    //lateinit var controller: Controller

    //TODO ПОМЕНЯТЬ БИНДИНГ КАК СДЕЛАНО В FirstFragment
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    //TODO ПРОЧЕСТЬ ПРО ListAdapter и про DiffUtil
    private lateinit var foodAdapter: FoodFragmentAdapter

    private val viewModel: FoodFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //controller = context as Controller
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodAdapter = FoodFragmentAdapter()
        binding.rvFood.layoutManager = LinearLayoutManager(requireContext())
        viewModel.fruitsList.observe(viewLifecycleOwner) {
            foodAdapter.setData(it)
        }
        binding.rvFood.adapter = foodAdapter

        binding.getDataButton.setOnClickListener {
            viewModel.getFruitInfo()
        }

    }

    override fun onResume() {
        super.onResume()
        updateAdapter()
    }

    private fun updateAdapter() {
        CoroutineScope(Dispatchers.Main).launch {
            val fruitsList = viewModel.getAllFruitsFromDatabase()
            foodAdapter.setData(fruitsList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

