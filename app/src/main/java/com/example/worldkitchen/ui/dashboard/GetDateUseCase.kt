package com.example.worldkitchen.ui.dashboard

import androidx.lifecycle.LiveData

class GetDateUseCase (private val repository: Repository){
    fun getItemList():LiveData<List<RestoranItem>>{
        return repository.getItem()
    }
}