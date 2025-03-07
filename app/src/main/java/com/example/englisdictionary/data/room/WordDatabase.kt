package com.example.englisdictionary.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.englisdictionary.data.dao.WordDao
import com.example.englisdictionary.data.model.Word

@Database(entities = [Word::class], version = 7, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        const val DATABASE_NAME = "dictionary.db"
        const val PATH_NAME = "dictionary_db.db"

        /**
         * As we need only one instance of db in our app will use to store
         * This is to avoid memory leaks in android when there exist multiple instances of db
         */
//        @Volatile
//        private var INSTANCE: WordDatabase? = null

//        fun getInstance(context: Context): WordDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        WordDatabase::class.java,
//                        DATABASE_NAME
//                    ).createFromAsset(PATH_NAME)
//                        .fallbackToDestructiveMigrationFrom()
//                        .build()
//
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
    }
}






