package com.yunha.moviewiki.presenter.model

import com.yunha.moviewiki.domain.model.BookItemEntity

data class BookItem(
    val title: String,
    val image: String
)

fun BookItemEntity.mapToPresentation(): BookItem = BookItem(
    title,
    image
)

fun List<BookItemEntity>.mapToPresentation(): MutableList<BookItem> =
    map { it.mapToPresentation() }.toMutableList()
