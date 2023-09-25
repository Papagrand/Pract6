package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.FruitListItem

class FoodFragmentAdapter: RecyclerView.Adapter<FoodFragmentAdapter.FoodViewHolder>() {

    var listFood = emptyList<FruitListItem>()

    class FoodViewHolder(view: View):RecyclerView.ViewHolder(view){
        val nameTextView: TextView = view.findViewById(R.id.textViewFruitName)
        val proteinTextView: TextView = view.findViewById(R.id.textViewFruitProtein)
        val fatTextView: TextView = view.findViewById(R.id.textViewFruitFat)
        val carbsTextView: TextView = view.findViewById(R.id.textViewFruitCarbs)
        val caloriesTextView: TextView = view.findViewById(R.id.textViewCalories)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodFragmentAdapter.FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodFragmentAdapter.FoodViewHolder, position: Int) {
        val currentItem = listFood[position]
        holder.nameTextView.text = currentItem.name
        holder.proteinTextView.text = currentItem.nutritions.protein.toString()
        holder.fatTextView.text = currentItem.nutritions.fat.toString()
        holder.carbsTextView.text = currentItem.nutritions.carbohydrates.toString()
        holder.caloriesTextView.text = currentItem.nutritions.calories.toString()
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    fun setData(newList: List<FruitListItem>) {
        listFood = newList
        notifyDataSetChanged()
    }
}