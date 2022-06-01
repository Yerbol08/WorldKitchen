package com.example.worldkitchen.ui.dashboard

import androidx.lifecycle.LiveData

interface Repository {
    fun getItem():LiveData<List<RestoranItem>>
    fun addItem(restoranItem: RestoranItem)
}