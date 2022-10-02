package com.example.dogglers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dogglers.databinding.ActivityDetailBinding

class DetailActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val TAG = "DetailActivity"

    companion object {
        const val DOG_IMAGE = "dogImage"
        const val DOG_NAME = "dogName"
        const val DOG_AGE = "dogAge"
        const val DOG_HOBBIES = "dogHobbies"
        const val DOG_SEX = "dogSex"
    }

    val dogImageResourceId = intent?.extras?.getString(DOG_IMAGE)
    val dogName = intent?.extras?.getString(DOG_NAME)
    val dogAge = intent?.extras?.getString(DOG_AGE)
    val dogHobbies = intent?.extras?.getString(DOG_HOBBIES)
    val dogSex = intent?.extras?.getString(DOG_SEX)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup view binding
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val heOrShe: String = when(dogSex){
            "male" -> "He"
            else -> "She"
        }
        binding.dogName.text = dogName
        Log.d(TAG, "${dogAge.toString()}, ${dogName.toString()}, $dogHobbies, $heOrShe, $dogImageResourceId")
        binding.dogDescription.text = getString(R.string.dog_description, dogName, dogAge, dogSex, dogHobbies)
        //binding.dogImage.setImageResource(dogImageResourceId!!.toInt())
        binding.dogImage.setImageResource(R.drawable.bella)
        Log.d(TAG, "dogDescription and dogImage were set")

        title = getString(R.string.details_about, dogName)
    }
}
