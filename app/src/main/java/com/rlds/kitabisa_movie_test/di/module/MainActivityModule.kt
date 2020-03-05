package com.rlds.kitabisa_movie_test.di.module

import com.rlds.kitabisa_movie_test.module.view.MainView
import dagger.Module
import dagger.Provides
import com.rlds.kitabisa_movie_test.di.scope.PerActivity
import com.rlds.kitabisa_movie_test.service.MainInteractorService
import com.rlds.kitabisa_movie_test.service.MovieService
import retrofit2.Retrofit

@Module
class MainActivityModule(mainView: MainView) {

    var mainView1:MainView

    init {
        mainView1 = mainView
    }

    @PerActivity
    @Provides
    fun provideRetrofitHelper(apiService: MovieService): MainInteractorService {
        return MainInteractorService(apiService)
    }

    @PerActivity
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java!!)
    }

    @PerActivity
    @Provides
    fun provideView(): MainView {
        return mainView1
    }
}