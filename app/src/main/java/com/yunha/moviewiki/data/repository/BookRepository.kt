package com.yunha.moviewiki.data.repository

import com.yunha.moviewiki.domain.model.BookEntity
import io.reactivex.Single

interface BookRepository {

    fun get(query: String): Single<BookEntity>
}
