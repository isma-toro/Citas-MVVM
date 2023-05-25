package com.ismael.ejemplomvvm.domain

import com.ismael.ejemplomvvm.data.QuoteRepository
import com.ismael.ejemplomvvm.data.model.QuoteModel
import com.ismael.ejemplomvvm.domain.model.Quote
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(
  private val repository: QuoteRepository
){

  suspend operator fun invoke() : Quote? {
    val quotes = repository.getAllQuotesFromDatabase()
    if (!quotes.isNullOrEmpty()) {
      val randomNumber = (quotes.indices).random()
      return quotes[randomNumber]
    }
    return null
  }
}