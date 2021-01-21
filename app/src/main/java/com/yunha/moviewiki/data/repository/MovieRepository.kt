package com.yunha.moviewiki.data.repository

import com.yunha.moviewiki.domain.model.MovieEntity
import io.reactivex.Single

interface MovieRepository {

    fun get(query: String): Single<MovieEntity>
}
