package com.rlds.kitabisa_movie_test.module.view

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import com.rlds.kitabisa_movie_test.module.base.BaseView
import io.realm.RealmResults

interface MainView : BaseView {

    fun getPopulerMovies(movie: Movie)

    fun getTopRatedMovies(movie: Movie)

    fun getNowPlayingMovies(movie: Movie)

    fun getMovieLocal(realmResults: RealmResults<MovieDbRealm>)
}