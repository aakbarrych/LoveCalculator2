package com.example.lovecalculator2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator2.remote.LoveModel
import com.example.lovecalculator2.repository.Repository

class LoveViewModel : ViewModel() {
    private val repository = Repository()
    fun getLiveLove(firstName: String, secondName: String):LiveData<LoveModel>{

        return repository.getLove(firstName, secondName)
    }
}