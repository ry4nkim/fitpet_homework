package dev.ry4nkim.fitpet_homework.domain.usecase.base

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> : UseCase() {

    internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(
        params: Params,
        onSuccess: ((t: T) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onError)
        compositeDisposable.add(lastDisposable)
    }
}