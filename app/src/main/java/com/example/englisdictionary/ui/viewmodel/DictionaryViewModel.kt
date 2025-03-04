package com.example.englisdictionary.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englisdictionary.data.model.Word
import com.example.englisdictionary.data.repository.WordRepository
import com.example.englisdictionary.data.repository.WordRepositoryImpl

class DictionaryViewModel : ViewModel() {
    private val repository: WordRepository = WordRepositoryImpl()

    private val _word = MutableLiveData<List<Word>>(listOf())
    val word: LiveData<List<Word>> get() = _word

    fun getWordData() {
        repository.getWorldList().also {
            _word.postValue(it)
        }
    }
}