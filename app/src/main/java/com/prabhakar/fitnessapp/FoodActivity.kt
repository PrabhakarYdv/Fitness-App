package com.prabhakar.fitnessapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.fitnessapp.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding
    private lateinit var foodAdapter: FoodAdapter
    private var tipsList = mutableListOf<TipsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            finish()
        }
        buildList()
    }

    private fun buildList() {
        tipsList.add(TipsModel("Build more Muscle"))
        tipsList.add(TipsModel("Replace Coffee with Green Tea"))
        tipsList.add(TipsModel("Just keep moving"))
        tipsList.add(TipsModel("Stop counting calories"))
        tipsList.add(TipsModel("Pick up a Kettlebell"))
        tipsList.add(TipsModel("Do Workout"))
        tipsList.add(TipsModel("Do Yoga"))
        tipsList.add(TipsModel("Get Intense"))
        tipsList.add(TipsModel("Stop sleeping much"))
        tipsList.add(TipsModel("Make one meal a day vegan"))
        tipsList.add(TipsModel("Go Green"))
        tipsList.add(TipsModel("Take Fresh Air"))
        tipsList.add(TipsModel("Walk everyday"))
    }

    private fun setRecyclerView() {
        foodAdapter = FoodAdapter(tipsList)
        binding.foodRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.foodRecyclerView.adapter = foodAdapter
    }
}