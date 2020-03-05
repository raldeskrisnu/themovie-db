package com.rlds.kitabisa_movie_test.module.base

import javax.inject.Inject

open class BasePresenter<V : BaseView> {

    @Inject
    lateinit var view: V

}

