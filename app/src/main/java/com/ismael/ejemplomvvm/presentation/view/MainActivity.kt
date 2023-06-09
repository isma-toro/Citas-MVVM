package com.ismael.ejemplomvvm.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.ismael.ejemplomvvm.R
import com.ismael.ejemplomvvm.databinding.ActivityMainBinding
import com.ismael.ejemplomvvm.presentation.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding : ActivityMainBinding

  private val quoteViewModel : QuoteViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    quoteViewModel.onCreate()

    quoteViewModel.quoteModel.observe(this) {currentQuote ->
      binding.tvQuote.text = currentQuote.quote
      binding.tvAuthor.text = currentQuote.author
    }

    quoteViewModel.isLoading.observe(this) {
      binding.progress.isVisible = it
    }

    binding.viewContainer.setOnClickListener {
      quoteViewModel.randomQuote()
    }
  }
}