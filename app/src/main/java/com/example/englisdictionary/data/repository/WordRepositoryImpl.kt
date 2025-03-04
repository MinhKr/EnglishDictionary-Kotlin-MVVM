package com.example.englisdictionary.data.repository

import com.example.englisdictionary.data.model.Word

class WordRepositoryImpl : WordRepository {
    override fun getWorldList()  = listOf(
        Word("fuck" , "Su giao cau"),
        Word("fuck" , "Su giao cau"),
        Word("fuck" , "Su giao cau"),
        Word("fuck" , "Su giao cau")
    )
}