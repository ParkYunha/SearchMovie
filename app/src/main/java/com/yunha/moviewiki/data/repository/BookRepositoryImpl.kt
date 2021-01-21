package com.yunha.moviewiki.data.repository

import com.yunha.moviewiki.data.remote.NaverRemoteDataSource
import com.yunha.moviewiki.domain.model.BookEntity
import io.reactivex.Single

class BookRepositoryImpl (
    private val remoteDataSource: NaverRemoteDataSource
): BookRepository {

    override fun get(query: String): Single<BookEntity> =
        remoteDataSource.getBook(query)

    companion object {
        private var INSTANCE: BookRepositoryImpl? = null

        fun getInstance(remoteDataSource: NaverRemoteDataSource) : BookRepository =
            INSTANCE ?: BookRepositoryImpl(remoteDataSource).apply {
                INSTANCE = this
            }
    }
}
