package com.yunha.moviewiki.data.repository

import com.yunha.moviewiki.data.remote.NaverRemoteDataSource
import com.yunha.moviewiki.domain.model.MovieEntity
import io.reactivex.Single

class MovieRepositoryImpl(
    private val remoteDataSource: NaverRemoteDataSource
) : MovieRepository {

    override fun get(query: String): Single<MovieEntity> =
        remoteDataSource.getMovie(query)

    companion object {
        private var INSTANCE: MovieRepositoryImpl? = null

        fun getInstance(remoteDataSource: NaverRemoteDataSource) : MovieRepository =
            INSTANCE ?: MovieRepositoryImpl(remoteDataSource).apply {
                INSTANCE = this
            }
    }
}
