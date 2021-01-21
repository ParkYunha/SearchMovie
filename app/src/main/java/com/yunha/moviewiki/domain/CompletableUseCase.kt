package com.yunha.moviewiki.domain

import com.yunha.moviewiki.util.SchedulersProvider
import io.reactivex.Completable

abstract class CompletableUseCase<in Params>(
    private val schedulersProvider: SchedulersProvider
) {

    protected abstract fun buildUseCaseCimpletable(params: Params): Completable

    fun get(params: Params): Completable = buildUseCaseCimpletable(params)
        .subscribeOn(schedulersProvider.io())
        .observeOn(schedulersProvider.ui())
}
