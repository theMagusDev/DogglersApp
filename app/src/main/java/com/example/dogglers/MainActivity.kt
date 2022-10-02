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
package com.example.dogglers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dogglers.adapter.DogCardAdapter
import com.example.dogglers.const.Layout
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.const.Layout.HORIZONTAL
import com.example.dogglers.const.Layout.VERTICAL
import com.example.dogglers.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private var layoutType = VERTICAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.verticalRecyclerView

        setUpAdapter()
    }

    fun setUpAdapter() {
        recyclerView.adapter = when(layoutType){
            VERTICAL -> {
                recyclerView.layoutManager = LinearLayoutManager(this, 1, false)
                DogCardAdapter(
                    applicationContext,
                    Layout.VERTICAL
                )
            }
            HORIZONTAL -> {
                recyclerView.layoutManager = LinearLayoutManager(this, 0, false)
                DogCardAdapter(
                    applicationContext,
                    Layout.HORIZONTAL
                )
            }
            else -> {
                recyclerView.layoutManager = GridLayoutManager(this, 2, 1, false)
                DogCardAdapter(
                    applicationContext,
                    Layout.GRID
                )
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon = when(layoutType) {
            VERTICAL -> ContextCompat.getDrawable(this, R.drawable.ic_vertical_layout)
            HORIZONTAL -> ContextCompat.getDrawable(this, R.drawable.ic_horizontal_layout)
            else -> ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_manu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_switch_layout -> {
                layoutType = when (layoutType) {
                    VERTICAL -> HORIZONTAL
                    HORIZONTAL -> GRID
                    else -> VERTICAL
                }
                setUpAdapter()

                return true
            }
            //  Otherwise, do nothing and use the core event handling

            // when clauses require that all possible paths be accounted for explicitly,
            //  for instance both the true and false cases if the value is a Boolean,
            //  or an else to catch all unhandled cases.

            else -> return super.onOptionsItemSelected(item)
        }
    }
}
