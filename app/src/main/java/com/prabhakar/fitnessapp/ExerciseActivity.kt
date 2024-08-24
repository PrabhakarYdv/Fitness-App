package com.prabhakar.fitnessapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.prabhakar.fitnessapp.databinding.ActivityExerciseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseBinding
    private var name: String? = null
    private var image: Int = 0
    private var duration = 0
    private var interstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = intent.getStringExtra("exerciseName")
        image = intent.getIntExtra("exerciseImage", 0)
        duration = intent.getIntExtra("exerciseDuration", R.drawable.exercise_1)

        MobileAds.initialize(this)
        showInterstitialAd()

        binding.apply {
            setSupportActionBar(toolBar)


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
            val totalSeconds = TimeUnit.MINUTES.toSeconds(duration.toLong())
            val tillSecond = 0
            for (second in totalSeconds downTo tillSecond) {
                if (second == 0.toLong()) {
                    showInterstitialAd()
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

    private fun showInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this@ExerciseActivity,
            getString(R.string.interstitial_ad_unit_id),
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    interstitialAd?.show(this@ExerciseActivity)
                    interstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {

                            override fun onAdDismissedFullScreenContent() {
                                this@ExerciseActivity.finish()
                            }

                            override fun onAdFailedToShowFullScreenContent(error: AdError) {
                                super.onAdFailedToShowFullScreenContent(error)
                                Log.d("ad", error.toString())
                            }

                            override fun onAdShowedFullScreenContent() {
                                interstitialAd = null
                            }

                            override fun onAdImpression() {
                                super.onAdImpression()
                            }
                        }
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitialAd = null
                }
            })

    }

}