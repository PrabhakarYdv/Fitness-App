package com.prabhakar.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.fitnessapp.databinding.ActivityAfterAgeBinding

class AfterAgeActivity : AppCompatActivity(), ClickListener {
    private lateinit var binding: ActivityAfterAgeBinding
    private val exerciseList = mutableListOf<Model>()
    private lateinit var exerciseAdapter: ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildList()
        setRecyclerView()
    }

    private fun buildList() {
        exerciseList.add(Model("MOUNTAIN CLIMBER", R.drawable.exercise_1, 1))
        exerciseList.add(Model("BASIC CRUNCHES", R.drawable.exercise_2, 1))
        exerciseList.add(Model("BENCH DIPS", R.drawable.exercise_3, 1))
        exerciseList.add(Model("BICYCLE CLIMBER", R.drawable.exercise_4, 1))
        exerciseList.add(Model("LEG RAISE", R.drawable.exercise_5, 1))
        exerciseList.add(Model("ALTERNATIVE HEEL TOUCH", R.drawable.exercise_6, 1))
        exerciseList.add(Model("LEG UP CRUNCHES", R.drawable.exercise_7, 1))
        exerciseList.add(Model("SIT UP", R.drawable.exercise_8, 1))
        exerciseList.add(Model("ALTERNATIVE UPS", R.drawable.exercise_9, 1))
        exerciseList.add(Model("PLANK ROTATION", R.drawable.exercise_10, 1))
        exerciseList.add(Model("PLANK WITH LEG LEFT", R.drawable.exercise_11, 1))
        exerciseList.add(Model("RUSSINA TWIST", R.drawable.exercise_12, 1))
        exerciseList.add(Model("BRIDGE", R.drawable.exercise_13, 1))
        exerciseList.add(Model("VERTICAL LEG CRUNCHES", R.drawable.exercise_14, 1))
        exerciseList.add(Model("WIND MILL", R.drawable.exercise_15, 1))
    }

    private fun setRecyclerView() {
        exerciseAdapter = ExerciseAdapter(exerciseList, this)
        binding.afterAgeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.afterAgeRecyclerView.adapter = exerciseAdapter
    }

    override fun onClick(model: Model, position: Int) {
//        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ExerciseActivity::class.java)
        intent.putExtra("exerciseName", model.exerciseName)
        intent.putExtra("exerciseImage", model.exerciseImage)
        intent.putExtra("exerciseDuration", model.exerciseDuration)
        startActivity(intent)
    }

}