package com.example.myapplication.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Controller
import com.example.myapplication.R
import com.example.myapplication.data.domain.DataBase
import com.example.myapplication.data.repository.RetrofitInstance
import com.example.myapplication.databinding.FragmentFoodBinding
import com.example.myapplication.view.FoodFragmentAdapter
import com.example.myapplication.domain.usecase.FruitUseCase
import com.example.myapplication.view.viewModel.FoodFragmentViewModel
//import com.example.myapplication.view.viewModelFactory.FoodFragmentViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class FoodFragment : Fragment() {
    lateinit var controller: Controller
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    private lateinit var foodAdapter: FoodFragmentAdapter
    private val viewModel: FoodFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        controller = context as Controller
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodAdapter = FoodFragmentAdapter()
        binding.rvFood.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFood.adapter = foodAdapter

//        viewModel = ViewModelProvider(
//            this,
//            FoodFragmentViewModelFactory(FruitUseCase(RetrofitInstance.create(), DataBase.getInstance(requireContext())))
//        ).get(FoodFragmentViewModel::class.java)

        binding.getDataButton.setOnClickListener {
            viewModel.getFruitInfo()
        }

        binding.firstFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_foodFragment_to_firstFragment)
        }
        binding.secondFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_foodFragment_to_secFragment)
        }
        binding.foodFragmentButton.setOnClickListener {
        }
    }

    override fun onResume() {
        super.onResume()
        updateAdapter()
    }

    private fun updateAdapter() {
        runBlocking {
            val fruitsList = viewModel.getAllFruitsFromDatabase()
            foodAdapter.setData(fruitsList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

