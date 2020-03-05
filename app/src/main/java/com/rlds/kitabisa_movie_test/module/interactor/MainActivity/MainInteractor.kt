package com.rlds.kitabisa_movie_test.module.interactor.MainActivity

import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import io.realm.Realm

interface MainInteractor {

    fun getPopulerMovie()

    fun getTopRatedMovie()

    fun getNowPlayingMovie()

    fun saveMovieLocal(movie: MovieDbRealm, realm: Realm)

    fun getMovieLocal(realm: Realm)
}