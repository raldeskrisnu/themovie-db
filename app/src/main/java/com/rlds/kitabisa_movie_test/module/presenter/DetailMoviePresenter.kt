package com.rlds.kitabisa_movie_test.module.presenter

import com.rlds.kitabisa_movie_test.model.MovieDetail
import com.rlds.kitabisa_movie_test.module.base.BasePresenter
import com.rlds.kitabisa_movie_test.module.interactor.DetailMovieActivity.DetailMovieActivityInteractor
import com.rlds.kitabisa_movie_test.module.interactor.DetailMovieActivity.DetailMovieInteractor
import com.rlds.kitabisa_movie_test.module.interactor.DetailMovieActivity.DetailMovieInteractorOutput
import com.rlds.kitabisa_movie_test.module.view.MovieDetailView
import com.rlds.kitabisa_movie_test.service.DetailMovieInteractorService
import com.rlds.kitabisa_movie_test.service.MovieService
import javax.inject.Inject

class DetailMoviePresenter @Inject constructor(
    private val movieDetailMovieInteractorService: DetailMovieInteractorService ): BasePresenter<MovieDetailView>(),
    DetailMovieInteractor, DetailMovieInteractorOutput {

    private val detailMovieInteractor: DetailMovieInteractor

    init {
        detailMovieInteractor = DetailMovieActivityInteractor(movieDetailMovieInteractorService, this)
    }

    override fun getDetailMovies(movieId: Int) {
        view?.showLoadingState()
        detailMovieInteractor?.getDetailMovies(movieId)
    }

    override fun onSuccessDetailMovie(movieDetail: MovieDetail) {
        view?.hideLoadingState()
        view?.getPopulerMovies(movieDetail)
    }

    override fun onErrorDetailMovie() {
        view?.hideLoadingState()
    }
}