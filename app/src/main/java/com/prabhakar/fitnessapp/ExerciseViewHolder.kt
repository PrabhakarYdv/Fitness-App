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
            duration.text = "${model.duration} MIN"
            exerciseImage.setImageDrawable(model.exerciseImages)

            exerciseLayout.setOnClickListener {
                clickListener.onClick(model, adapterPosition)
            }
        }
    }
}