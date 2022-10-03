package com.example.dogglers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogglers.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    companion object {
        const val DOG_IMAGE = "dogImage"
        const val DOG_NAME = "dogName"
        const val DOG_AGE = "dogAge"
        const val DOG_HOBBIES = "dogHobbies"
        const val DOG_SEX = "dogSex"
    }

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // private lateinit var dogImageResourceId: Int will give an error,
    // that's why i use 11111111 here
    private var dogImageResourceId: Int = 11111111
    private lateinit var dogName: String
    private lateinit var dogAge: String
    private lateinit var dogHobbies: String
    private lateinit var dogSex: String

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
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}