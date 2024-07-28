package com.prabhakar.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.fitnessapp.databinding.ActivityAfterAgeBinding

class AfterAgeActivity : AppCompatActivity(), ClickListener {
    private lateinit var binding: ActivityAfterAgeBinding
    private val exerciseList = mutableListOf<ExerciseModel>()
    private lateinit var exerciseAdapter: ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        buildList()
        setRecyclerView()
    }

    private fun buildList() {
        exerciseList.add(ExerciseModel("MOUNTAIN CLIMBER", R.drawable.exercise_1, 1))
        exerciseList.add(ExerciseModel("BASIC CRUNCHES", R.drawable.exercise_2, 1))
        exerciseList.add(ExerciseModel("BENCH DIPS", R.drawable.exercise_3, 1))
        exerciseList.add(ExerciseModel("BICYCLE CLIMBER", R.drawable.exercise_4, 1))
        exerciseList.add(ExerciseModel("LEG RAISE", R.drawable.exercise_5, 1))
        exerciseList.add(ExerciseModel("ALTERNATIVE HEEL TOUCH", R.drawable.exercise_6, 1))
        exerciseList.add(ExerciseModel("LEG UP CRUNCHES", R.drawable.exercise_7, 1))
        exerciseList.add(ExerciseModel("SIT UP", R.drawable.exercise_8, 1))
        exerciseList.add(ExerciseModel("ALTERNATIVE UPS", R.drawable.exercise_9, 1))
        exerciseList.add(ExerciseModel("PLANK ROTATION", R.drawable.exercise_10, 1))
        exerciseList.add(ExerciseModel("PLANK WITH LEG LEFT", R.drawable.exercise_11, 1))
        exerciseList.add(ExerciseModel("RUSSINA TWIST", R.drawable.exercise_12, 1))
        exerciseList.add(ExerciseModel("BRIDGE", R.drawable.exercise_13, 1))
        exerciseList.add(ExerciseModel("VERTICAL LEG CRUNCHES", R.drawable.exercise_14, 1))
        exerciseList.add(ExerciseModel("WIND MILL", R.drawable.exercise_15, 1))
    }

    private fun setRecyclerView() {
        exerciseAdapter = ExerciseAdapter(exerciseList, this)
        binding.afterAgeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.afterAgeRecyclerView.adapter = exerciseAdapter
    }

    override fun onClick(model: ExerciseModel, position: Int) {
//        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ExerciseActivity::class.java)
        intent.putExtra("exerciseName", model.exerciseName)
        intent.putExtra("exerciseImage", model.exerciseImage)
        intent.putExtra("exerciseDuration", model.exerciseDuration)
        startActivity(intent)
    }

}