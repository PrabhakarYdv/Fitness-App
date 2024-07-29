package com.prabhakar.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
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
//
//        MobileAds.initialize(this) {}
//        val adRequest = AdRequest.Builder().build()
//        binding.bannerAdView.loadAd(adRequest)
//
//        binding.bannerAdView.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                Toast.makeText(this@HomeActivity, "Ad Loaded", Toast.LENGTH_LONG)
//            }
//
//            override fun onAdFailedToLoad(error: LoadAdError) {
//                Toast.makeText(this@HomeActivity, "${error.message}", Toast.LENGTH_LONG)
//
//            }
//
//        }

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
            Toast.makeText(this, "Coming Soon...!!", Toast.LENGTH_SHORT).show()
            return true
        }
        if (menuId == R.id.tc) {
            Toast.makeText(this, "Coming Soon...!!", Toast.LENGTH_SHORT).show()
            return true
        }
        if (menuId == R.id.share) {
            Toast.makeText(this, "Coming Soon...!!", Toast.LENGTH_SHORT).show()
            return true
        }
        if (menuId == R.id.rate) {
            Toast.makeText(this, "Coming Soon...!!", Toast.LENGTH_SHORT).show()
            return true
        }
        return true
    }
}