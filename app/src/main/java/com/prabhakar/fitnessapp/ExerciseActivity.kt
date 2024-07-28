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
        val exerciseName = intent.getStringExtra("exerciseName")
        val exerciseImage = intent.getIntExtra("exerciseImage", 0)
        val exerciseDuration = intent.getIntExtra("exerciseDuration", R.drawable.exercise_1)
    }
}