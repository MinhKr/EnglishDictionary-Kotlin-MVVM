package com.example.englisdictionary.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.englisdictionary.R
import com.example.englisdictionary.databinding.ActivityMainBinding
import com.example.englisdictionary.ui.adapter.WordAdapter
import com.example.englisdictionary.ui.fragment.dictionary.DictionaryFragment
import com.example.englisdictionary.ui.fragment.favourite.FavouriteFragment
import com.example.englisdictionary.ui.fragment.game.GameFragment
import com.example.englisdictionary.ui.fragment.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadFragment(DictionaryFragment())

        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dictionary -> {
                    loadFragment(DictionaryFragment())
                    true
                }

                R.id.game -> {
                    loadFragment(GameFragment())
                    true
                }

                R.id.favourite -> {
                    loadFragment(FavouriteFragment())
                    true
                }

                R.id.setting -> {
                    loadFragment(SettingFragment())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}