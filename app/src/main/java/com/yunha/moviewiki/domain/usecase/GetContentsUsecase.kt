package com.yunha.moviewiki.domain.usecase

import com.yunha.moviewiki.data.repository.BookRepository
import com.yunha.moviewiki.data.repository.MovieRepository
import com.yunha.moviewiki.domain.SingleUseCase
import com.yunha.moviewiki.domain.model.BookEntity
import com.yunha.moviewiki.domain.model.BookItemEntity
import com.yunha.moviewiki.domain.model.MovieEntity
import com.yunha.moviewiki.domain.model.MovieItemEntity
import com.yunha.moviewiki.util.SchedulersProvider
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class GetContentsUsecase(
    private val bookRepository: BookRepository,
    private val movieRepository: MovieRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<Pair<List<BookItemEntity>, List<MovieItemEntity>>, String>(
    schedulersProvider
) {
    override fun buildUseCaseSingle(params: String): Single<Pair<List<BookItemEntity>, List<MovieItemEntity>>> {
        return Single.zip(
            bookRepository.get(params),
            movieRepository.get(params),
            BiFunction<BookEntity, MovieEntity, Pair<List<BookItemEntity>, List<MovieItemEntity>>> {
                book, movie -> Pair(book.items, movie.items)
            }
        )
    }
}
