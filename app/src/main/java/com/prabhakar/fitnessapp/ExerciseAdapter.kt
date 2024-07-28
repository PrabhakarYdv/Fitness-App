package com.prabhakar.fitnessapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.fitnessapp.databinding.ExerciseLayoutBinding

class ExerciseAdapter(
    private val exerciseList: MutableList<Model>,
    private val clickListener: ClickListener
) : RecyclerView.Adapter<ExerciseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = ExerciseLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExerciseViewHolder(view, clickListener)
    }


    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val model = exerciseList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }
}