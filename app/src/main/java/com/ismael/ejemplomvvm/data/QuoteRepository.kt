package com.ismael.ejemplomvvm.data

import com.ismael.ejemplomvvm.data.database.dao.QuoteDao
import com.ismael.ejemplomvvm.data.database.entities.QuoteEntity
import com.ismael.ejemplomvvm.data.network.QuoteService
import com.ismael.ejemplomvvm.domain.model.Quote
import com.ismael.ejemplomvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
  private val api: QuoteService,
  private val quoteDao: QuoteDao
) {

  suspend fun getAllQuotesFromApi(): List<Quote> {
    val response = api.getQuotes()
    return response.map { it.toDomain() }
  }

  suspend fun getAllQuotesFromDatabase() : List<Quote>{
      val response = quoteDao.getAllQuotes()
      return response.map { it.toDomain() }
  }

  suspend fun insertQuotes(quotes : List<QuoteEntity>) {
    quoteDao.insertAll(quotes)
  }

  suspend fun clearQuotes() {
    quoteDao.deleteAllQuotes()
  }

}