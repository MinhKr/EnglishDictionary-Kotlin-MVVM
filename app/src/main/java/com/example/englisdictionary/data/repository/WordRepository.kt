package com.example.englisdictionary.data.repository

import androidx.lifecycle.LiveData
import com.example.englisdictionary.data.model.Word

interface WordRepository {
    fun getWords(): List<Word>
}