package com.rlds.kitabisa_movie_test.module.interactor.MainActivity

import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import com.rlds.kitabisa_movie_test.service.MainInteractorService
import com.rlds.kitabisa_movie_test.utils.DisposableUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm

class MainActivityInteractor(
    private val interactorService: MainInteractorService,
    private val interactorOutput: MainActivityInteractorOutput) : MainInteractor {

    var disposable: Disposable?=null

    override fun getNowPlayingMovie() {
        DisposableUtils.dispose(disposable)

        disposable = interactorService.getNowPlayingService().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                interactorOutput.onSuccessNowPlaying(it)
            }, { error ->
                interactorOutput.onError()
            })
    }

    override fun getPopulerMovie() {
        DisposableUtils.dispose(disposable)

        disposable = interactorService.getPopulerMovieService().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                interactorOutput.onSuccessPopulerMovie(it)
            }, {
                error -> interactorOutput.onError()
            })
    }

    override fun getTopRatedMovie() {
        DisposableUtils.dispose(disposable)

        disposable = interactorService.getTopRatedMovieService().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                interactorOutput.onSuccessTopRated(it)
            }, { error ->
                interactorOutput.onError()
            })
    }

    override fun saveMovieLocal(movie: MovieDbRealm, realm: Realm) {
        realm.executeTransaction(object : Realm.Transaction {
            override fun execute(realm: Realm?) {
                if (realm != null) {

                    val currentIdNum: Number = realm!!.where(MovieDbRealm::class.java).max("id")!!
                    val nextId: Int

                    if (currentIdNum == null) {
                        nextId = 1
                    } else {
                        nextId = currentIdNum!!.toInt() + 1
                    }
                    movie.setId(nextId)
                    val model = realm!!.copyToRealm(movie)
                }
            }
        })
    }

    override fun getMovieLocal(realm: Realm) {
        val results = realm.where(MovieDbRealm::class.java).findAll()
        interactorOutput.onSuccessgetLocalMovie(results)
    }
}