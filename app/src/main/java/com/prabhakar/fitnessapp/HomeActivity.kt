package com.prabhakar.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.prabhakar.fitnessapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            setSupportActionBar(toolBar)
            btnGetStartedBefore.setOnClickListener {
                beforeAge18()
            }

            beforeAge18.setOnClickListener {
                beforeAge18()
            }

            btnGetStartedAfter.setOnClickListener {
                afterAge18()
            }

            afterAge18.setOnClickListener {
                afterAge18()
            }

            goToFood.setOnClickListener {
                goToFood()
            }
        }

    }

    private fun beforeAge18() {
        startActivity(Intent(this, BeforeAgeActivity::class.java))
    }

    private fun afterAge18() {
        startActivity(Intent(this, AfterAgeActivity::class.java))

    }

    private fun goToFood() {
        startActivity(Intent(this, FoodActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menuId = item.itemId
        if (menuId == R.id.privacy) {
            return true
        }
        if (menuId == R.id.tc) {
            return true
        }
        if (menuId == R.id.share) {
            return true
        }
        if (menuId == R.id.rate) {
            return true
        }
        return true
    }
}