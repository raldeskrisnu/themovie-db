package com.rlds.kitabisa_movie_test.di.component

import com.rlds.kitabisa_movie_test.di.module.MainActivityModule
import com.rlds.kitabisa_movie_test.di.module.MovieDetailActivityModule
import com.rlds.kitabisa_movie_test.di.scope.PerActivity
import com.rlds.kitabisa_movie_test.module.activity.detailactivity.DetailMovieActivity
import dagger.Component


@PerActivity
@Component(modules = arrayOf(MovieDetailActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface MovieDetailActivityComponent {

    fun inject(movieDetailMovieActivity: DetailMovieActivity)
}