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
    result.putInt("dogImage", this.dogImage)
    result.putString("dogName", this.dogName)
    result.putString("dogAge", this.dogAge)
    result.putString("dogHobbies", this.dogHobbies)
    result.putString("dogSex", this.dogSex)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("dogImage", this.dogImage)
    result.set("dogName", this.dogName)
    result.set("dogAge", this.dogAge)
    result.set("dogHobbies", this.dogHobbies)
    result.set("dogSex", this.dogSex)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __dogImage : Int
      if (bundle.containsKey("dogImage")) {
        __dogImage = bundle.getInt("dogImage")
      } else {
        throw IllegalArgumentException("Required argument \"dogImage\" is missing and does not have an android:defaultValue")
      }
      val __dogName : String?
      if (bundle.containsKey("dogName")) {
        __dogName = bundle.getString("dogName")
        if (__dogName == null) {
          throw IllegalArgumentException("Argument \"dogName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogName\" is missing and does not have an android:defaultValue")
      }
      val __dogAge : String?
      if (bundle.containsKey("dogAge")) {
        __dogAge = bundle.getString("dogAge")
        if (__dogAge == null) {
          throw IllegalArgumentException("Argument \"dogAge\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogAge\" is missing and does not have an android:defaultValue")
      }
      val __dogHobbies : String?
      if (bundle.containsKey("dogHobbies")) {
        __dogHobbies = bundle.getString("dogHobbies")
        if (__dogHobbies == null) {
          throw IllegalArgumentException("Argument \"dogHobbies\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogHobbies\" is missing and does not have an android:defaultValue")
      }
      val __dogSex : String?
      if (bundle.containsKey("dogSex")) {
        __dogSex = bundle.getString("dogSex")
        if (__dogSex == null) {
          throw IllegalArgumentException("Argument \"dogSex\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogSex\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__dogImage, __dogName, __dogAge, __dogHobbies, __dogSex)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __dogImage : Int?
      if (savedStateHandle.contains("dogImage")) {
        __dogImage = savedStateHandle["dogImage"]
        if (__dogImage == null) {
          throw IllegalArgumentException("Argument \"dogImage\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogImage\" is missing and does not have an android:defaultValue")
      }
      val __dogName : String?
      if (savedStateHandle.contains("dogName")) {
        __dogName = savedStateHandle["dogName"]
        if (__dogName == null) {
          throw IllegalArgumentException("Argument \"dogName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogName\" is missing and does not have an android:defaultValue")
      }
      val __dogAge : String?
      if (savedStateHandle.contains("dogAge")) {
        __dogAge = savedStateHandle["dogAge"]
        if (__dogAge == null) {
          throw IllegalArgumentException("Argument \"dogAge\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogAge\" is missing and does not have an android:defaultValue")
      }
      val __dogHobbies : String?
      if (savedStateHandle.contains("dogHobbies")) {
        __dogHobbies = savedStateHandle["dogHobbies"]
        if (__dogHobbies == null) {
          throw IllegalArgumentException("Argument \"dogHobbies\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogHobbies\" is missing and does not have an android:defaultValue")
      }
      val __dogSex : String?
      if (savedStateHandle.contains("dogSex")) {
        __dogSex = savedStateHandle["dogSex"]
        if (__dogSex == null) {
          throw IllegalArgumentException("Argument \"dogSex\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"dogSex\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__dogImage, __dogName, __dogAge, __dogHobbies, __dogSex)
    }
  }
}
