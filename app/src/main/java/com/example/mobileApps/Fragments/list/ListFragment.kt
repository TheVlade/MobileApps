package com.example.mobileApps.fragments.list

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileApps.R

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val items = listOf(
            ListItem(1, "ListItem 1", R.drawable.sample_image),
            ListItem(2, "ListItem 2", R.drawable.sample_image),
            ListItem(3, "ListItem 3", R.drawable.sample_image)
        )

        val adapter = ListAdapter(items, { item ->
            Toast.makeText(requireContext(), "Clicked item: ${item.id}", Toast.LENGTH_SHORT).show()
            Log.d("com.example.mobileApps.fragments.list.ListFragment", "Clicked item: ${item.id}")
        }, { item, action ->
            Toast.makeText(requireContext(), "Clicked $action on item: ${item.id}", Toast.LENGTH_SHORT).show()
            Log.d("com.example.mobileApps.fragments.list.ListFragment", "Clicked $action on item: ${item.id}")
        })

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}