package com.rlds.kitabisa_movie_test.module.view

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.module.base.BaseView

interface MainView : BaseView {

    fun getPopulerMovies(movie: Movie)

    fun getTopRatedMovies(movie: Movie)

    fun getNowPlayingMovies(movie: Movie)
}