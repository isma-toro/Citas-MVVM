package com.ismael.ejemplomvvm.domain

import com.ismael.ejemplomvvm.data.QuoteRepository
import com.ismael.ejemplomvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomQuoteUseCaseTest {

  @RelaxedMockK
  private lateinit var quoteRepository: QuoteRepository
  lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

  @Before
  fun onBefore() {
    // Inicializamos el mock
    MockKAnnotations.init(this)
    getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
  }

  @Test
  fun `when database is empty return null`() = runBlocking {
    //Given
    coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
    //When
    val response = getRandomQuoteUseCase()
    //Then
    assert(response == null)
  }

  @Test
  fun `when database is not empty then return quote`() = runBlocking {
    //Given
    val quoteList = listOf(Quote("Holi", "Isma"))
    coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList
    //When
    val response = getRandomQuoteUseCase()
    //Then
    assert(response == quoteList.first())

  }

}