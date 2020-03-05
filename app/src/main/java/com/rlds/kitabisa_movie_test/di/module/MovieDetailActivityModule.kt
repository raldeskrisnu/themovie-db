package com.rlds.kitabisa_movie_test.di.module

import com.rlds.kitabisa_movie_test.di.scope.PerActivity
import com.rlds.kitabisa_movie_test.module.view.MainView
import com.rlds.kitabisa_movie_test.module.view.MovieDetailView
import com.rlds.kitabisa_movie_test.service.DetailMovieInteractorService
import com.rlds.kitabisa_movie_test.service.MainInteractorService
import com.rlds.kitabisa_movie_test.service.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MovieDetailActivityModule(movieDetailView: MovieDetailView) {

    val movieDetailView1: MovieDetailView

    init {
        movieDetailView1 = movieDetailView
    }

    @PerActivity
    @Provides
    fun provideRetrofitHelper(apiService: MovieService): DetailMovieInteractorService {
        return DetailMovieInteractorService(apiService)
    }

    @PerActivity
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java!!)
    }

    @PerActivity
    @Provides
    fun provideView(): MovieDetailView {
        return movieDetailView1
    }
}