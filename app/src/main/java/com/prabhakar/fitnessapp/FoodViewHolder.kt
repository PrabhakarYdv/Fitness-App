package com.prabhakar.fitnessapp

import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.fitnessapp.databinding.FoodLayoutBinding

class FoodViewHolder(private val binding: FoodLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(model: TipsModel) {
        binding.tipsText.text = model.tips
    }
}