package com.yunha.moviewiki.data.remote

import com.yunha.moviewiki.data.remote.model.mapToDomain
import com.yunha.moviewiki.domain.model.BookEntity
import com.yunha.moviewiki.domain.model.MovieEntity
import io.reactivex.Single

class NaverRemoteDataSourceImpl(
    private val api: NaverService
): NaverRemoteDataSource {

    override fun getMovie(query: String): Single<MovieEntity> =
        api.getMovie(query).map { it.mapToDomain() }

    override fun getBook(query: String): Single<BookEntity> =
        api.getBook(query).map { it.mapToDomain() }
}
