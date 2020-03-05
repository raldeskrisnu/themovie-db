package com.rlds.kitabisa_movie_test.module.view

import com.rlds.kitabisa_movie_test.model.MovieDetail
import com.rlds.kitabisa_movie_test.module.base.BaseView

interface MovieDetailView : BaseView {

    fun getPopulerMovies(movieId: MovieDetail)
}