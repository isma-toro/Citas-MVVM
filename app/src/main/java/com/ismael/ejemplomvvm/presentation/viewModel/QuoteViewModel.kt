package com.ismael.ejemplomvvm.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ejemplomvvm.domain.GetQuoteUseCase
import com.ismael.ejemplomvvm.domain.GetRandomQuoteUseCase
import com.ismael.ejemplomvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
  private val getQuotesUseCase : GetQuoteUseCase,
  private val getRandomQuoteUseCase : GetRandomQuoteUseCase
): ViewModel() {
  val quoteModel = MutableLiveData<Quote>()
  val isLoading = MutableLiveData<Boolean>()

  fun onCreate() {
    viewModelScope.launch {
        isLoading.postValue(true)
        val result = getQuotesUseCase()
        if (!result.isNullOrEmpty()) {
          quoteModel.postValue(result[0])
          isLoading.postValue(false)
        }
    }
  }

  fun randomQuote() = viewModelScope.launch{
    isLoading.postValue(true)
    val quote = getRandomQuoteUseCase()
    if (quote != null) {
      quoteModel.postValue(quote!!)
    }
    isLoading.postValue(false)
  }

}