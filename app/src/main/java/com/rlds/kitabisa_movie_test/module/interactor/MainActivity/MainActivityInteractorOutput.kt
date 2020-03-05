package com.rlds.kitabisa_movie_test.module.interactor.MainActivity

import com.rlds.kitabisa_movie_test.model.Movie

interface MainActivityInteractorOutput {

    fun onSuccessPopulerMovie(movie: Movie)

    fun onSuccessNowPlaying(movie: Movie)

    fun onSuccessTopRated(movie: Movie)

    fun onError()
}