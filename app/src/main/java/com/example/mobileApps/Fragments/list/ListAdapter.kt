package com.example.mobileApps.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileApps.R

class ListAdapter(
    private val items: List<ListItem>,
    private val onItemClick: (ListItem) -> Unit,
    private val onButtonClick: (ListItem, String) -> Unit
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClick, onButtonClick)
    }

    override fun getItemCount() = items.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val likeButton: Button = itemView.findViewById(R.id.likeButton)
        private val shareButton: Button = itemView.findViewById(R.id.shareButton)

        fun bind(
            item: ListItem,
            onItemClick: (ListItem) -> Unit,
            onButtonClick: (ListItem, String) -> Unit
        ) {
            imageView.setImageResource(item.imageResId)
            titleTextView.text = item.title
            itemView.setOnClickListener { onItemClick(item) }
            likeButton.setOnClickListener { onButtonClick(item, "like") }
            shareButton.setOnClickListener { onButtonClick(item, "share") }
        }
    }
}