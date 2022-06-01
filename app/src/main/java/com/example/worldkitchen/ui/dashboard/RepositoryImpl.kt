package com.example.worldkitchen.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.worldkitchen.R

object RepositoryImpl:Repository {
    private val item = mutableListOf<RestoranItem>()
    private val itemLD = MutableLiveData<List<RestoranItem>>()

    init {

        var item = RestoranItem("Астау", R.drawable.rest1, "1 500–5 000 тенге", 4.5)
        addItem(item)
        item = RestoranItem("Arnau", R.drawable.rest2, "3 000–10 000 тенге", 4.8)
        addItem(item)
        item = RestoranItem("Жибек-Жолы", R.drawable.rest3, "8 000–10 000 тенге", 4.3)
        addItem(item)
        item = RestoranItem("Ак Тілек", R.drawable.rest4, "12 000 тенге", 4.0)
        addItem(item)
        item = RestoranItem("Jumbaktas", R.drawable.rest5, "7 000–10 000 тенге", 4.0)
        addItem(item)

    }
    override fun getItem(): LiveData<List<RestoranItem>> {
        return itemLD
    }

    override fun addItem(restoranItem: RestoranItem) {
        item.add(restoranItem)
        updateList()
    }

    private fun updateList() {
        itemLD.value = item.toList()
    }
}