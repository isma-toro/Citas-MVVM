package com.ismael.ejemplomvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ismael.ejemplomvvm.data.database.dao.QuoteDao
import com.ismael.ejemplomvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {
  abstract fun getQuoteDao() : QuoteDao
}