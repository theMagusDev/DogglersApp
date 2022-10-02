package com.example.dogglers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import com.example.dogglers.DetailFragment.Companion.DOG_AGE
import com.example.dogglers.DetailFragment.Companion.DOG_HOBBIES
import com.example.dogglers.DetailFragment.Companion.DOG_IMAGE
import com.example.dogglers.DetailFragment.Companion.DOG_NAME
import com.example.dogglers.DetailFragment.Companion.DOG_SEX
import com.example.dogglers.databinding.FragmentDetailBinding

private var _binding: FragmentDetailBinding? = null
private val binding = _binding!!

private var dogImageResourceId: Int? = null
private lateinit var dogName: String
private lateinit var dogAge: String
private lateinit var dogHobbies: String
private lateinit var dogSex: String

class DetailFragment : Fragment() {

    companion object {
        const val DOG_IMAGE = "dogImage"
        const val DOG_NAME = "dogName"
        const val DOG_AGE = "dogAge"
        const val DOG_HOBBIES = "dogHobbies"
        const val DOG_SEX = "dogSex"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            dogImageResourceId = it.getInt(DOG_IMAGE)
            dogName = it.getString(DOG_NAME).toString()
            dogAge = it.getString(DOG_AGE).toString()
            dogHobbies = it.getString(DOG_HOBBIES).toString()
            dogSex = it.getString(DOG_SEX).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val heOrShe: String = when(dogSex){
            "male" -> "He"
            else -> "She"
        }
        binding.dogName.text = dogName
        binding.dogDescription.text = getString(R.string.dog_description, dogName, dogAge, heOrShe, dogHobbies)
        binding.dogImage.setImageResource(dogImageResourceId!!.toInt())

        //title = getString(R.string.details_about, dogName)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}