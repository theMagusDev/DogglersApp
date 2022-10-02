/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.DetailFragment.Companion.DOG_AGE
import com.example.dogglers.DetailFragment.Companion.DOG_HOBBIES
import com.example.dogglers.DetailFragment.Companion.DOG_IMAGE
import com.example.dogglers.DetailFragment.Companion.DOG_NAME
import com.example.dogglers.DetailFragment.Companion.DOG_SEX
import com.example.dogglers.DogListFragmentDirections
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.const.Layout.HORIZONTAL
import com.example.dogglers.const.Layout.VERTICAL
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // Initialize the data using the List found in data/DataSource
    val data = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val dogName: TextView = view!!.findViewById(R.id.dog_name)
        val dogAge: TextView = view!!.findViewById(R.id.dog_age)
        val dogHobbies: TextView = view!!.findViewById(R.id.dog_hobbies)
        var dogSex = "n/a"
        val showDetailsButton: Button = view!!.findViewById(R.id.details_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val layoutType = when(layout) {
            VERTICAL -> R.layout.vertical_list_item
            HORIZONTAL -> R.layout.horizontal_list_item
            else -> R.layout.grid_list_item
        }

        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(layoutType, parent, false)

        // Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context?.resources

        // Get the data at the current position
        val item = data[position]

        // Set the image resource for the current dog
        holder.imageView.setImageResource(item.imageResourceId)

        // Set the text for the current dog's name
        holder.dogName.text = item.name

        // Set the text for the current dog's age
        holder.dogAge.text = resources?.getString(R.string.dog_age, item.age)

        // Set the text for dog's hobbies
        holder.dogHobbies.text = resources?.getString(R.string.dog_hobbies, item.hobbies)

        // Set the dog's sex variable
        holder.dogSex = item.sex

        // Setting up OnClickListener
        holder.showDetailsButton.setOnClickListener {
            val action = DogListFragmentDirections.actionDogListFragmentToDetailFragment(
                dogImage = item.imageResourceId,
                dogName = item.name,
                dogAge = item.age,
                dogHobbies = item.hobbies,
                dogSex = item.sex
            )
            Log.d("DogCardAdapter", "${item.imageResourceId}, ${item.name}, ${item.age}, ${item.hobbies}, ${item.sex}")
            Log.d("DogCardAdapter", "$action")
            holder.itemView.findNavController().navigate(action)
        }
    }

}
