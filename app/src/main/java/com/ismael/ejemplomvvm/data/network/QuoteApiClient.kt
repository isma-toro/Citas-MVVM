package com.ismael.ejemplomvvm.data.network

import com.ismael.ejemplomvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
  @GET("/.json")
  suspend fun getAllQuotes() : Response<List<QuoteModel>>
}