package com.example.englisdictionary.data.repository

import androidx.lifecycle.LiveData
import com.example.englisdictionary.data.dao.WordDao
import com.example.englisdictionary.data.model.Word
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class WordRepositoryImpl @Inject constructor(
    private val wordDao: WordDao
) : WordRepository {
    /*private val words = mutableListOf<Word>()

    init {
        words.add(Word("fuck", "ádasdasdas"))
        words.add(Word("Minh" , "anisdiad"))
        words.add(Word("áda" , "anisdiad"))
        words.add(Word("cxzv" , "anisdiad"))
        words.add(Word("thg" , "anisdiad"))
        words.add(Word("czxfer" , "anisdiad"))
        words.add(Word("fgng" , "anisdiad"))
        words.add(Word("czxbhhj" , "anisdiad"))
        words.add(Word("adooc", "ádacavawfsc"))
        wordDao.insertWords(words)
    }*/

    override fun getWords(): List<Word> {
        return wordDao.getAllWords()
    }
}