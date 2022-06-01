package com.example.worldkitchen.ui.dashboard

class AddItemUseCase (private val repository: Repository){
    fun addItem(restoranItem: RestoranItem){
        repository.addItem(restoranItem)
    }
}