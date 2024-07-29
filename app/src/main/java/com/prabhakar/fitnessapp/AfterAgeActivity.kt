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
        exerciseList.add(ExerciseModel("MOUNTAIN CLIMBER", R.drawable.exercise_1, 2))
        exerciseList.add(ExerciseModel("BASIC CRUNCHES", R.drawable.exercise_2, 2))
        exerciseList.add(ExerciseModel("BENCH DIPS", R.drawable.exercise_3, 2))
        exerciseList.add(ExerciseModel("BICYCLE CLIMBER", R.drawable.exercise_4, 2))
        exerciseList.add(ExerciseModel("LEG RAISE", R.drawable.exercise_5, 2))
        exerciseList.add(ExerciseModel("ALTERNATIVE HEEL TOUCH", R.drawable.exercise_6, 2))
        exerciseList.add(ExerciseModel("LEG UP CRUNCHES", R.drawable.exercise_7, 2))
        exerciseList.add(ExerciseModel("SIT UP", R.drawable.exercise_8, 2))
        exerciseList.add(ExerciseModel("ALTERNATIVE UPS", R.drawable.exercise_9, 2))
        exerciseList.add(ExerciseModel("PLANK ROTATION", R.drawable.exercise_10, 2))
        exerciseList.add(ExerciseModel("PLANK WITH LEG LEFT", R.drawable.exercise_11, 2))
        exerciseList.add(ExerciseModel("RUSSINA TWIST", R.drawable.exercise_12, 2))
        exerciseList.add(ExerciseModel("BRIDGE", R.drawable.exercise_13, 2))
        exerciseList.add(ExerciseModel("VERTICAL LEG CRUNCHES", R.drawable.exercise_14, 2))
        exerciseList.add(ExerciseModel("WIND MILL", R.drawable.exercise_15, 2))
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