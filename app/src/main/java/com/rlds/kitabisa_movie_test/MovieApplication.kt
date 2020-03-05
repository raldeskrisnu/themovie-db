package com.rlds.kitabisa_movie_test

import android.app.Application
import com.rlds.kitabisa_movie_test.di.module.ApplicationModule
import com.rlds.kitabisa_movie_test.di.component.ApplicationComponent
import com.rlds.kitabisa_movie_test.di.component.DaggerApplicationComponent
import io.realm.RealmConfiguration
import io.realm.Realm

class MovieApplication : Application() {

    private var applicationComponent: ApplicationComponent

    init {
        applicationComponent = DaggerApplicationComponent.builder().
                applicationModule(ApplicationModule(this))
                .build()


    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("movie.realm").build()
        Realm.setDefaultConfiguration(config)
    }


    fun applicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        }

        return applicationComponent
    }

}