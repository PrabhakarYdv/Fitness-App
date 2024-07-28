package com.prabhakar.fitnessapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.fitnessapp.databinding.FoodLayoutBinding

class FoodAdapter(private val tipsList: MutableList<TipsModel>) :
    RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = FoodLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val model = tipsList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return tipsList.size
    }

}