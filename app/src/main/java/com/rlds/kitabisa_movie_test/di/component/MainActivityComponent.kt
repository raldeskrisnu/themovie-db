package com.rlds.kitabisa_movie_test.di.component

import com.rlds.kitabisa_movie_test.di.module.MainActivityModule
import com.rlds.kitabisa_movie_test.di.scope.PerActivity
import dagger.Component
import com.rlds.kitabisa_movie_test.module.activity.mainactivity.MainActivity

@PerActivity
@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}
