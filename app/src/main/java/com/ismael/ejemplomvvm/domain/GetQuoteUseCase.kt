package com.ismael.ejemplomvvm.domain

import com.ismael.ejemplomvvm.data.QuoteRepository
import com.ismael.ejemplomvvm.data.database.entities.toDatabase
import com.ismael.ejemplomvvm.data.model.QuoteModel
import com.ismael.ejemplomvvm.domain.model.Quote
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val repository : QuoteRepository) {
  suspend operator fun invoke() : List<Quote> {
    val quotes = repository.getAllQuotesFromApi()

    return if (quotes.isNotEmpty()) {
      repository.clearQuotes()
      repository.insertQuotes(quotes.map { it.toDatabase() })
      quotes
    } else {
      repository.getAllQuotesFromDatabase()
    }
  }
}