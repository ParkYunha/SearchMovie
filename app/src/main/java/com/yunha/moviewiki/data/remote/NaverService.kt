package com.yunha.moviewiki.data.remote

import com.yunha.moviewiki.data.remote.model.BookModel
import com.yunha.moviewiki.data.remote.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverService {

    @GET("search/movie.json")
    fun getMovie(
        @Query("query") query: String,
        @Query("display") display: Int = 10,
        @Query("start") start: Int = 1
    ): Single<MovieModel>

    @GET("search/book.json")
    fun getBook(
        @Query("query") query: String,
        @Query("display") display: Int = 10,
        @Query("start") start: Int = 1
    ): Single<BookModel>
}
