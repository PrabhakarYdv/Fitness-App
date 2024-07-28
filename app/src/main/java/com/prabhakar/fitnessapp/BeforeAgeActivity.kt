package com.prabhakar.fitnessapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.fitnessapp.databinding.ActivityBeforeAgeBinding

class BeforeAgeActivity : AppCompatActivity(), ClickListener {
    private val exerciseList = mutableListOf<Model>()
    private lateinit var exerciseAdapter: ExerciseAdapter
    private lateinit var binding: ActivityBeforeAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeforeAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildList()
        setRecyclerView()
    }

    private fun buildList() {
        exerciseList.add(Model("MOUNTAIN CLIMBER", R.drawable.exersice_1, 1))
        exerciseList.add(Model("BASIC CRUNCHES", R.drawable.exersice_2, 1))
        exerciseList.add(Model("BENCH DIPS", R.drawable.exersice_3, 1))
        exerciseList.add(Model("BICYCLE CLIMBER", R.drawable.exersice_4, 1))
        exerciseList.add(Model("LEG RAISE", R.drawable.exersice_5, 1))
        exerciseList.add(Model("ALTERNATIVE HEEL TOUCH", R.drawable.exersice_6, 1))
        exerciseList.add(Model("LEG UP CRUNCHES", R.drawable.exersice_7, 1))
        exerciseList.add(Model("SIT UP", R.drawable.exersice_8, 1))
        exerciseList.add(Model("ALTERNATIVE UPS", R.drawable.exersice_9, 1))
        exerciseList.add(Model("PLANK ROTATION", R.drawable.exersice_10, 1))
        exerciseList.add(Model("PLANK WITH LEG LEFT", R.drawable.exersice_11, 1))
        exerciseList.add(Model("RUSSINA TWIST", R.drawable.exersice_12, 1))
        exerciseList.add(Model("BRIDGE", R.drawable.exersice_13, 1))
        exerciseList.add(Model("VERTICAL LEG CRUNCHES", R.drawable.exersice_14, 1))
        exerciseList.add(Model("WIND MILL", R.drawable.exersice_15, 1))
    }

    private fun setRecyclerView() {
        exerciseAdapter = ExerciseAdapter(exerciseList, this)
        binding.beforeAgeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.beforeAgeRecyclerView.adapter = exerciseAdapter
    }

    override fun onClick(model: Model, position: Int) {
        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
    }

}