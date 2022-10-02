package com.example.dogglers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogglers.DetailFragment.Companion.DOG_AGE
import com.example.dogglers.DetailFragment.Companion.DOG_HOBBIES
import com.example.dogglers.DetailFragment.Companion.DOG_IMAGE
import com.example.dogglers.DetailFragment.Companion.DOG_NAME
import com.example.dogglers.DetailFragment.Companion.DOG_SEX
import com.example.dogglers.databinding.FragmentDetailBinding

private var _binding: FragmentDetailBinding? = null
private val binding = _binding!!

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
        setHasOptionsMenu(true)
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

        val dogImageResourceId = activity?.intent?.extras?.getInt(DOG_IMAGE)
        val dogName = activity?.intent?.extras?.getString(DOG_NAME)
        val dogAge = activity?.intent?.extras?.getString(DOG_AGE)
        val dogHobbies = activity?.intent?.extras?.getString(DOG_HOBBIES)
        val dogSex = activity?.intent?.extras?.getString(DOG_SEX)

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