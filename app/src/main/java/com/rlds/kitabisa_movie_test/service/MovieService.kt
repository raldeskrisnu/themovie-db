package com.rlds.kitabisa_movie_test.service

import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    companion object {

        const val API_KEY = "?api_key=321e3c990bf5421f1e48f2584df867e9"
    }

    @GET("movie/popular" + API_KEY)
    fun popularMovies(): Observable<Movie>

    @GET("movie/top_rated"+ API_KEY)
    fun topRated(): Observable<Movie>

    @GET("movie/now_playing" + API_KEY)
    fun nowPlaying(): Observable<Movie>

    @GET("movie/{movie_id}"+ API_KEY)
    fun movieDetails(@Path("movie_id") movieId: Int): Observable<MovieDetail>

    @GET("movie/{movie_id}/reviews" + API_KEY)
    fun movieReviews(@Path("movie_id") movieId: Int)
}