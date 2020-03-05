package com.rlds.kitabisa_movie_test.di.component

import com.rlds.kitabisa_movie_test.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton
import retrofit2.Retrofit

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun exposeRetrofit(): Retrofit

}