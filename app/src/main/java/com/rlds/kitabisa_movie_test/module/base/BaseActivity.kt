package com.rlds.kitabisa_movie_test.module.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.annotation.CallSuper
import butterknife.ButterKnife
import com.rlds.kitabisa_movie_test.MovieApplication
import com.rlds.kitabisa_movie_test.di.component.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        ButterKnife.bind(this)
        resolveDaggerDependency()
    }

    protected open fun resolveDaggerDependency() {}

    protected abstract fun getContentView(): Int

    protected fun applicationComponent(): ApplicationComponent {
        val application = application as MovieApplication
        return application.applicationComponent()
    }
}