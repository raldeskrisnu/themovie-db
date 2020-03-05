package com.rlds.kitabisa_movie_test.module.interactor.MainActivity

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import io.realm.RealmResults

interface MainActivityInteractorOutput {

    fun onSuccessPopulerMovie(movie: Movie)

    fun onSuccessNowPlaying(movie: Movie)

    fun onSuccessTopRated(movie: Movie)

    fun onSuccessgetLocalMovie(realmResults: RealmResults<MovieDbRealm>)

    fun onError()
}