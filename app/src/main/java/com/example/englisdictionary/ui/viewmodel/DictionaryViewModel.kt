package com.example.englisdictionary.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.englisdictionary.data.model.Word
import com.example.englisdictionary.data.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val repository: WordRepository
) : ViewModel() {
    //    val words: List<Word> get() = repository.getWords()
    fun getWords(): List<Word> {
        return repository.getWords()
    }
}

