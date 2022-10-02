package com.example.dogglers

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.adapter.DogCardAdapter
import com.example.dogglers.const.Layout
import com.example.dogglers.databinding.FragmentDogListBinding

private var _binding: FragmentDogListBinding? = null
private val binding get() = _binding!!
private lateinit var recyclerView: RecyclerView
private var layoutType = Layout.VERTICAL

class DogListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.verticalRecyclerView
        setUpAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_manu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)

        // Calls code to set the icon
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_switch_layout -> {
                layoutType = when (layoutType) {
                    Layout.VERTICAL -> Layout.HORIZONTAL
                    Layout.HORIZONTAL -> Layout.GRID
                    else -> Layout.VERTICAL
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

    fun setUpAdapter() {
        recyclerView.adapter = when(layoutType){
            Layout.VERTICAL -> {
                recyclerView.layoutManager = LinearLayoutManager(context, 1, false)
                DogCardAdapter(
                    context,
                    Layout.VERTICAL
                )
            }
            Layout.HORIZONTAL -> {
                recyclerView.layoutManager = LinearLayoutManager(context, 0, false)
                DogCardAdapter(
                    context,
                    Layout.HORIZONTAL
                )
            }
            else -> {
                recyclerView.layoutManager = GridLayoutManager(context, 2, 1, false)
                DogCardAdapter(
                    context,
                    Layout.GRID
                )
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon = when(layoutType) {
            Layout.VERTICAL -> ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_vertical_layout)
            Layout.HORIZONTAL -> ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_horizontal_layout)
            else -> ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
        }
    }
}