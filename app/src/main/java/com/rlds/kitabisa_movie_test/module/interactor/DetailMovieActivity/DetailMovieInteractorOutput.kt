package com.rlds.kitabisa_movie_test.module.interactor.DetailMovieActivity

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDetail

interface DetailMovieInteractorOutput {

    fun onSuccessDetailMovie(movieDetail: MovieDetail)

    fun onErrorDetailMovie()
}