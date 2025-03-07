package com.example.englisdictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.englisdictionary.data.model.Word

@Dao
interface WordDao {
    @Insert
    fun insertWord(word: Word)

    @Update
    fun updateWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWords(words : List<Word>)

    @Query("SELECT * FROM word_tbl LIMIT 30")
    fun getAllWords() : List<Word>
}