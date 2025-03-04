package com.example.englisdictionary.data.repository

import com.example.englisdictionary.data.model.Word

interface WordRepository {
    fun getWorldList(): List<Word>
}