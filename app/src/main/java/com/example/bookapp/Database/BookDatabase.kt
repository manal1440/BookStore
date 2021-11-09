package com.example.bookapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookapp.Database.entities.Book
import com.example.bookapp.Database.entities.Category
import com.example.bookapp.Database.entities.User


@Database(
    entities = [
        Book::class,
        Category::class,
        User::class,
    ],
    version = 1
)
abstract class BookDatabase : RoomDatabase() {
    abstract val bookDao: BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext, BookDatabase::class.java, "book_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}