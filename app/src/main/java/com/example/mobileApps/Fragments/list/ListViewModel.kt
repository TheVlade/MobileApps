package com.example.mobileApps.fragments.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.mobileApps.R

class ListViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<ListItem2>>(emptyList())
    val items: StateFlow<List<ListItem2>> = _items.asStateFlow()

    private val allItems = listOf(
        ListItem2(1, "Sushi", R.drawable.sushi_image),
        ListItem2(2, "Barszcz", R.drawable.barszcz_image),
        ListItem2(3, "Pierogi", R.drawable.pierogi_image)
    )

    fun searchItems(query: String) {
        viewModelScope.launch {
            if (query.length >= 3) {
                _items.value = allItems.filter {
                    it.title.contains(query, ignoreCase = true)
                }
            } else {
                _items.value = allItems
            }
        }
    }
}