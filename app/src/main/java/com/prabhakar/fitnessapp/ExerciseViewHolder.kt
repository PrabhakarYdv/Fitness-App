package com.prabhakar.fitnessapp

import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.fitnessapp.databinding.ExerciseLayoutBinding

class ExerciseViewHolder(
    private val binding: ExerciseLayoutBinding,
    private val clickListener: ClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(model: Model) {
        binding.apply {
            exerciseName.text = model.exerciseName
            duration.text = "0${model.duration}:00 MIN"
            exerciseImage.setImageResource(model.exerciseImages)

            exerciseLayout.setOnClickListener {
                clickListener.onClick(model, adapterPosition)
            }
        }
    }
}