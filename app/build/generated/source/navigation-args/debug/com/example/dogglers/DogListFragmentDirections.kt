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
        result.putInt("dog_image", this.dogImage)
        result.putString("dog_name", this.dogName)
        result.putString("dog_age", this.dogAge)
        result.putString("dog_hobbies", this.dogHobbies)
        result.putString("dog_sex", this.dogSex)
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
