package com.example.dogglers

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val dogImage: Int,
  public val dogName: String,
  public val dogAge: String,
  public val dogHobbies: String,
  public val dogSex: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("dog_image", this.dogImage)
    result.putString("dog_name", this.dogName)
    result.putString("dog_age", this.dogAge)
    result.putString("dog_hobbies", this.dogHobbies)
    result.putString("dog_sex", this.dogSex)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("dog_image", this.dogImage)
    result.set("dog_name", this.dogName)
    result.set("dog_age", this.dogAge)
    result.set("dog_hobbies", this.dogHobbies)
    result.set("dog_sex", this.dogSex)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __dogImage : Int
      if (bundle.containsKey("dog_image")) {
        __dogImage = bundle.getInt("dog_image")
      } else {
        throw IllegalArgumentException("Required argument \"dog_image\" is missing and does not have an android:defaultValue")
      }
      val __dogName : String?
      if (bundle.containsKey("dog_name")) {
        __dogName = bundle.getString("dog_name")
        if (__dogName == null) {
          throw IllegalArgumentException("Argument \"dog_name\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_name\" is missing and does not have an android:defaultValue")
      }
      val __dogAge : String?
      if (bundle.containsKey("dog_age")) {
        __dogAge = bundle.getString("dog_age")
        if (__dogAge == null) {
          throw IllegalArgumentException("Argument \"dog_age\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_age\" is missing and does not have an android:defaultValue")
      }
      val __dogHobbies : String?
      if (bundle.containsKey("dog_hobbies")) {
        __dogHobbies = bundle.getString("dog_hobbies")
        if (__dogHobbies == null) {
          throw IllegalArgumentException("Argument \"dog_hobbies\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_hobbies\" is missing and does not have an android:defaultValue")
      }
      val __dogSex : String?
      if (bundle.containsKey("dog_sex")) {
        __dogSex = bundle.getString("dog_sex")
        if (__dogSex == null) {
          throw IllegalArgumentException("Argument \"dog_sex\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_sex\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__dogImage, __dogName, __dogAge, __dogHobbies, __dogSex)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __dogImage : Int?
      if (savedStateHandle.contains("dog_image")) {
        __dogImage = savedStateHandle["dog_image"]
        if (__dogImage == null) {
          throw IllegalArgumentException("Argument \"dog_image\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_image\" is missing and does not have an android:defaultValue")
      }
      val __dogName : String?
      if (savedStateHandle.contains("dog_name")) {
        __dogName = savedStateHandle["dog_name"]
        if (__dogName == null) {
          throw IllegalArgumentException("Argument \"dog_name\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_name\" is missing and does not have an android:defaultValue")
      }
      val __dogAge : String?
      if (savedStateHandle.contains("dog_age")) {
        __dogAge = savedStateHandle["dog_age"]
        if (__dogAge == null) {
          throw IllegalArgumentException("Argument \"dog_age\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_age\" is missing and does not have an android:defaultValue")
      }
      val __dogHobbies : String?
      if (savedStateHandle.contains("dog_hobbies")) {
        __dogHobbies = savedStateHandle["dog_hobbies"]
        if (__dogHobbies == null) {
          throw IllegalArgumentException("Argument \"dog_hobbies\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_hobbies\" is missing and does not have an android:defaultValue")
      }
      val __dogSex : String?
      if (savedStateHandle.contains("dog_sex")) {
        __dogSex = savedStateHandle["dog_sex"]
        if (__dogSex == null) {
          throw IllegalArgumentException("Argument \"dog_sex\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dog_sex\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__dogImage, __dogName, __dogAge, __dogHobbies, __dogSex)
    }
  }
}
