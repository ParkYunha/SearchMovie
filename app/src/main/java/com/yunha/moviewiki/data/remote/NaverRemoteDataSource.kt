package com.yunha.moviewiki.data.remote

import com.yunha.moviewiki.domain.model.BookEntity
import com.yunha.moviewiki.domain.model.MovieEntity
import io.reactivex.Single

interface NaverRemoteDataSource {

    fun getMovie(
        query: String
    ): Single<MovieEntity>

    fun getBook(
        query: String
    ): Single<BookEntity>
}
