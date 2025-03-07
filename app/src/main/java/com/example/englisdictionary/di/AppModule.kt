package com.example.englisdictionary.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.englisdictionary.data.dao.WordDao
import com.example.englisdictionary.data.repository.WordRepository
import com.example.englisdictionary.data.repository.WordRepositoryImpl
import com.example.englisdictionary.data.room.WordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context) =
//        Room.databaseBuilder(
//            context.applicationContext,
//            WordDatabase::class.java,
//            WordDatabase.DATABASE_NAME
//        ).createFromAsset(WordDatabase.PATH_NAME)
//            .fallbackToDestructiveMigrationFrom()
//            .build()

    @Provides
    @Singleton
    fun provideRepository(wordDao: WordDao): WordRepository = WordRepositoryImpl(wordDao)

    /*    @Provides
        @Singleton
        fun provideWordDao(@ApplicationContext context: Context): WordDao {
            return WordDatabase.getInstance(context).wordDao()
        }*/

    private const val TAG = "AppModule" // Tag cho logcat

    @Provides
    @Singleton
    fun provideWordDatabase(@ApplicationContext context: Context): WordDatabase {
        println("Starting to create database from assets...")
        Log.d(TAG, "Starting to create database from assets...")

        val database = Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            WordDatabase.DATABASE_NAME
        ).createFromAsset(WordDatabase.PATH_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        // Kiểm tra xem database có mở thành công không
        val isOpen = database.isOpen
        println("Database created. Is open: $isOpen")
        Log.d(TAG, "Database created. Is open: $isOpen")

        return database
    }


    @Provides
    @Singleton
    fun provideWordDao(database: WordDatabase): WordDao {
        return database.wordDao()
    }

}