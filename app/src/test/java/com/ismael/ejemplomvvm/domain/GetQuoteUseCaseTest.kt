package com.ismael.ejemplomvvm.domain

import com.ismael.ejemplomvvm.data.QuoteRepository
import com.ismael.ejemplomvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuoteUseCaseTest {

  @RelaxedMockK
  private lateinit var quoteRepository: QuoteRepository

  lateinit var getQuotesUseCase: GetQuoteUseCase


  @Before
  fun onBefore() {
    MockKAnnotations.init(this)
    getQuotesUseCase = GetQuoteUseCase(quoteRepository)
  }

  @Test
  fun `when the api doesnt return anything then get values from database`() = runBlocking {
    //Given
    coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()
    //When
    getQuotesUseCase()

    //Then
    coVerify(exactly = 1) {
      quoteRepository.getAllQuotesFromDatabase()
    }
  }

  @Test
  fun `when the api return something then get values from api`() = runBlocking {
    //Given
    val myList = listOf(Quote("PRUEBAS MVVM", "ISMA"))
    coEvery { quoteRepository.getAllQuotesFromApi() } returns myList
    // When
    val respuesta = getQuotesUseCase()
    //Then
    coVerify(exactly = 1) { quoteRepository.clearQuotes() }
    coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
    coVerify(exactly = 0) {
      quoteRepository.getAllQuotesFromDatabase()
    }
    assert(myList == respuesta)
  }


}