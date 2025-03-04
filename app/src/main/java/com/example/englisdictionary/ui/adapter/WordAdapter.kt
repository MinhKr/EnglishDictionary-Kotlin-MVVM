package com.example.englisdictionary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.englisdictionary.data.model.Word
import com.example.englisdictionary.databinding.ItemDictionaryBinding

class WordAdapter(private val words: List<Word>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemDictionaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDictionaryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = words[position]
        holder.binding.word = word
    }

    override fun getItemCount(): Int = words.size
}