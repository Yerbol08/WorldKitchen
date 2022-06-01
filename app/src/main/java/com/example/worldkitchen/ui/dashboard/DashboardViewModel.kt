package com.example.worldkitchen.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    private val repository = RepositoryImpl
    private val getItemUseCase = GetDateUseCase(repository)

    val item = getItemUseCase.getItemList()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}