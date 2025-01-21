package com.example.mobileApps.fragments.list

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileApps.R

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val likeButton: Button = itemView.findViewById(R.id.likeButton)
    private val shareButton: Button = itemView.findViewById(R.id.shareButton)

    fun bind(
        item: ListItem2,
        onItemClick: (ListItem2) -> Unit,
        onButtonClick: (ListItem2, String) -> Unit
    ) {
        imageView.setImageResource(item.imageResId)
        titleTextView.text = item.title
        itemView.setOnClickListener { onItemClick(item) }
        likeButton.setOnClickListener { onButtonClick(item, "like") }
        shareButton.setOnClickListener { onButtonClick(item, "share") }
    }
}