package com.yunha.moviewiki.presenter.model

import com.yunha.moviewiki.domain.model.MovieItemEntity

data class MovieItem(
    val title: String,
    val image: String,
    val director: String,
    val actor: String,
    val rating: String
)

fun MovieItemEntity.mapToPresentation(): MovieItem = MovieItem(
    title,
    image,
    director.replace("|", ",").dropLast(2),
    actor.replace("|", ",").dropLast(2),
    rating.toString()
)

fun List<MovieItemEntity>.mapToPresentation(): MutableList<MovieItem> =
    map { it.mapToPresentation() }.toMutableList()
