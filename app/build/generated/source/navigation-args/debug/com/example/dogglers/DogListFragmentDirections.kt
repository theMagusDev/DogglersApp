package com.example.dogglers

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class DogListFragmentDirections private constructor() {
  private data class ActionDogListFragmentToDetailFragment(
    public val dogImage: Int,
    public val dogName: String,
    public val dogAge: String,
    public val dogHobbies: String,
    public val dogSex: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dogListFragment_to_detailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("dogImage", this.dogImage)
        result.putString("dogName", this.dogName)
        result.putString("dogAge", this.dogAge)
        result.putString("dogHobbies", this.dogHobbies)
        result.putString("dogSex", this.dogSex)
        return result
      }
  }

  public companion object {
    public fun actionDogListFragmentToDetailFragment(
      dogImage: Int,
      dogName: String,
      dogAge: String,
      dogHobbies: String,
      dogSex: String
    ): NavDirections = ActionDogListFragmentToDetailFragment(dogImage, dogName, dogAge, dogHobbies,
        dogSex)
  }
}
