package com.ismael.ejemplomvvm.domain.model

import com.ismael.ejemplomvvm.data.database.entities.QuoteEntity
import com.ismael.ejemplomvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String) {

}


fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
