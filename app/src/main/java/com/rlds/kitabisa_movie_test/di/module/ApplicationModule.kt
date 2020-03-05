package com.rlds.kitabisa_movie_test.di.module

import android.content.Context
import android.os.Debug
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

import retrofit2.converter.gson.GsonConverterFactory;
import com.rlds.kitabisa_movie_test.BuildConfig
import com.rlds.kitabisa_movie_test.constant.Constant
import com.rlds.kitabisa_movie_test.di.scope.PerActivity
import com.rlds.kitabisa_movie_test.network.AndroidInterceptor
import com.rlds.kitabisa_movie_test.service.MainInteractorService
import com.rlds.kitabisa_movie_test.service.MovieService
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Named
import retrofit2.Retrofit

@Module
class ApplicationModule(context: Context) {

    var myContext : Context

    init {
        this.myContext = context
    }

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    @Named("ok-1")
    fun provideOkHttpClient( httpLoggingInterceptor: HttpLoggingInterceptor,
                             androidInterceptor: AndroidInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(androidInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("ok-1") okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory,
        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun androidInterceptor(): AndroidInterceptor {
        return AndroidInterceptor()
    }

    @Provides
    @Singleton
    fun context() : Context {
        return myContext
    }

}