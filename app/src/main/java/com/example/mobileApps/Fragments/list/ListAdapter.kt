package com.example.mobileApps.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mobileApps.R

class ListAdapter(
    private val onItemClick: (ListItem2) -> Unit,

    private val onButtonClick: (ListItem2, String) -> Unit
) : ListAdapter<ListItem2, ListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClick, onButtonClick)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem2>() {
            override fun areItemsTheSame(oldItem: ListItem2, newItem: ListItem2): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListItem2, newItem: ListItem2): Boolean {
                return oldItem == newItem
            }
        }
    }
}
