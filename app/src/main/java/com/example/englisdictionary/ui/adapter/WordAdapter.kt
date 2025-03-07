package com.example.englisdictionary.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.englisdictionary.R
import com.example.englisdictionary.data.model.Word
import com.example.englisdictionary.databinding.ItemDictionaryBinding
import com.example.englisdictionary.ui.fragment.detail.DetailFragment

class WordAdapter(private var words: List<Word>, private val fragment: Fragment) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

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

        holder.itemView.setOnClickListener {
            val detailFragment = DetailFragment.newInstance(word.word ?: "", word.mean ?: "")
            fragment.parentFragmentManager.beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = words.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newWords: List<Word>) {
        words = newWords
        notifyDataSetChanged()
    }
}