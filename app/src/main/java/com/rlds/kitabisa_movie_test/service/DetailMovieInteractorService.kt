package com.rlds.kitabisa_movie_test.service

import com.rlds.kitabisa_movie_test.model.MovieDetail
import io.reactivex.Observable

class DetailMovieInteractorService(private val service: MovieService?) {

    fun getDetailMovie(movieId: Int): Observable<MovieDetail> {
        return service?.movieDetails(movieId)!!
    }
}