package com.rlds.kitabisa_movie_test.module.presenter

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import com.rlds.kitabisa_movie_test.module.base.BasePresenter
import com.rlds.kitabisa_movie_test.module.interactor.MainActivity.MainActivityInteractor
import com.rlds.kitabisa_movie_test.module.interactor.MainActivity.MainActivityInteractorOutput
import com.rlds.kitabisa_movie_test.module.interactor.MainActivity.MainInteractor
import com.rlds.kitabisa_movie_test.module.view.MainView
import com.rlds.kitabisa_movie_test.service.MainInteractorService
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val mainInteractorService: MainInteractorService): BasePresenter<MainView>(),
    MainInteractor, MainActivityInteractorOutput {

    private val mainInteractor: MainInteractor

    init {
        mainInteractor = MainActivityInteractor(mainInteractorService!!, this)
    }

    override fun getNowPlayingMovie() {
        view?.showLoadingState()
        mainInteractor?.getNowPlayingMovie()
    }

    override fun getPopulerMovie() {
        view?.showLoadingState()
        mainInteractor?.getPopulerMovie()
    }

    override fun getTopRatedMovie() {
        view?.showLoadingState()
        mainInteractor?.getTopRatedMovie()
    }

    override fun onSuccessNowPlaying(movie: Movie) {
        view?.hideLoadingState()
        view?.getNowPlayingMovies(movie)
    }

    override fun onSuccessPopulerMovie(movie: Movie) {
        view?.hideLoadingState()
        view?.getPopulerMovies(movie)
    }

    override fun onSuccessTopRated(movie: Movie) {
        view?.hideLoadingState()
        view?.getTopRatedMovies(movie)
    }

    override fun onError() {
        view?.hideLoadingState()
    }

    override fun getMovieLocal(realm: Realm) {
        mainInteractor?.getMovieLocal(realm)
    }

    override fun onSuccessgetLocalMovie(realmResults: RealmResults<MovieDbRealm>) {
        view?.getMovieLocal(realmResults)
    }

    override fun saveMovieLocal(movie: MovieDbRealm, realm: Realm) {
        mainInteractor?.saveMovieLocal(movie, realm)
    }

}