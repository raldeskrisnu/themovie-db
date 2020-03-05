package com.rlds.kitabisa_movie_test.service

import com.rlds.kitabisa_movie_test.model.Movie
import io.reactivex.Observable

class MainInteractorService(private val service: MovieService?) {


    fun getPopulerMovieService() : Observable<Movie> {
        return service?.popularMovies()!!
    }

    fun getTopRatedMovieService() : Observable<Movie> {
        return service?.topRated()!!
    }

    fun getNowPlayingService() : Observable<Movie> {
        return service?.nowPlaying()!!
    }
}