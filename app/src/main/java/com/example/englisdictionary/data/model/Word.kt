package com.example.englisdictionary.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_tbl")
data class Word(
    @PrimaryKey
    val word: String,
    val av: ByteArray?,
    val mean: String?
)
