package com.rlds.kitabisa_movie_test.module.interactor.DetailMovieActivity

import com.rlds.kitabisa_movie_test.service.DetailMovieInteractorService
import com.rlds.kitabisa_movie_test.utils.DisposableUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DetailMovieActivityInteractor(
            private val interactorService: DetailMovieInteractorService,
            private val interactorOutput: DetailMovieInteractorOutput) : DetailMovieInteractor {

    var disposable: Disposable?=null

    override fun getDetailMovies(movieId: Int) {
        DisposableUtils.dispose(disposable)

        disposable = interactorService.getDetailMovie(movieId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                interactorOutput.onSuccessDetailMovie(it)
            }, { error ->
                interactorOutput.onErrorDetailMovie()
            })
    }


}
