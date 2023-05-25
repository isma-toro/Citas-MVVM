package com.ismael.ejemplomvvm.presentation.viewModel

import com.ismael.ejemplomvvm.domain.GetQuoteUseCase
import com.ismael.ejemplomvvm.domain.GetRandomQuoteUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before

class QuoteViewModelTest {
  @RelaxedMockK
  private lateinit var getQuotesUseCase : GetQuoteUseCase
  @RelaxedMockK
  private lateinit var getRandomeQuoteUseCase : GetRandomQuoteUseCase

  private lateinit var quoteViewModel : QuoteViewModel

  @Before
  fun onBefore() {
    MockKAnnotations.init(this)
    quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomeQuoteUseCase)
  }



}