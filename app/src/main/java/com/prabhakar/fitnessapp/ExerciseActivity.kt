package com.prabhakar.fitnessapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prabhakar.fitnessapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("exerciseName")
        val image = intent.getIntExtra("exerciseImage", 0)
        val duration = intent.getIntExtra("exerciseDuration", R.drawable.exercise_1)
        binding.apply {
            exerciseName.text = name
            exerciseImage.setImageResource(image)
            timer.text="0${duration}:00"
        }
    }

}