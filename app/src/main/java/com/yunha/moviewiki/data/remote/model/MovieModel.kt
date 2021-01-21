package com.yunha.moviewiki.data.remote.model

import com.google.gson.annotations.SerializedName
import com.yunha.moviewiki.domain.model.MovieEntity
import com.yunha.moviewiki.domain.model.MovieItemEntity

data class MovieModel(
    @field:SerializedName("lastBuildDate") val lastBuildDate: String,
    @field:SerializedName("total") val total: Int,
    @field:SerializedName("start") val start: Int,
    @field:SerializedName("display") val display: Int,
    @field:SerializedName("items") val items: List<MovieItemModel>
)

fun MovieModel.mapToDomain() =
    MovieEntity(lastBuildDate, total, start, display, items.mapToDomain())

fun List<MovieItemModel>.mapToDomain(): List<MovieItemEntity> =
    map { MovieItemEntity(it.title, it.image, it.director, it.actor, it.userRating) }
