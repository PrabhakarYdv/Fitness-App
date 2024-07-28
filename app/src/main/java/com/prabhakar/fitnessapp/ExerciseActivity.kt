package com.prabhakar.fitnessapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.prabhakar.fitnessapp.databinding.ActivityExerciseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

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
            timer.text = "0${duration}:00"

            btnStart.setOnClickListener {
                startTimer()
//                finish()
                btnStart.visibility = View.GONE
            }
        }

    }

    private fun startTimer() {
        CoroutineScope(Dispatchers.Main).launch {
            val totalSeconds = TimeUnit.MINUTES.toSeconds(1)
            val tillSecond = 0
            for (second in totalSeconds downTo tillSecond) {
                if (second == 0.toLong()) {
                    finish()
                }
                val time = String.format(
                    "%02d:%02d",
                    TimeUnit.SECONDS.toMinutes(second),
                    second - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(second))
                )
                binding.timer.text = time
                delay(1000)

            }

        }

    }

}