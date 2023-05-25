package com.ismael.ejemplomvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ismael.ejemplomvvm.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(
  @ColumnInfo(name = "id")
  @PrimaryKey(autoGenerate = true)
  val id : Int = 0,
  @ColumnInfo(name = "quote")
  val quote: String,
  @ColumnInfo(name = "author")
  val author: String
) {
}

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)
