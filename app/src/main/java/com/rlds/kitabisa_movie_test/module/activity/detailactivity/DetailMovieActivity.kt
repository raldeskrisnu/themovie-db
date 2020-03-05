package com.rlds.kitabisa_movie_test.module.activity.detailactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rlds.kitabisa_movie_test.R
import com.rlds.kitabisa_movie_test.constant.Constant
import com.rlds.kitabisa_movie_test.di.component.DaggerMovieDetailActivityComponent
import com.rlds.kitabisa_movie_test.di.module.MovieDetailActivityModule
import com.rlds.kitabisa_movie_test.model.MovieDetail
import com.rlds.kitabisa_movie_test.module.base.BaseActivity
import com.rlds.kitabisa_movie_test.module.presenter.DetailMoviePresenter

import com.rlds.kitabisa_movie_test.module.view.MovieDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailMovieActivity : BaseActivity(), MovieDetailView {

    var movieDetailPresenter: DetailMoviePresenter? = null
        @Inject set

    companion object {

        private const val MOVIE_ID = "movieId"

        fun intentOpenMovieDetail(context: Context, movieId: Int) {

            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(MOVIE_ID, movieId)
            context?.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var movieId: Int = intent.getIntExtra(MOVIE_ID, 0)

        movieDetailPresenter?.getDetailMovies(movieId)

        uiview_bookmark_image.setOnClickListener {
            Toast.makeText(applicationContext,"Clicked", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getContentView(): Int {
        return R.layout.activity_detail_movie
    }

    override fun getPopulerMovies(movieDetail: MovieDetail) {

        uiview_title_movie.setText(movieDetail.originalTitle)
        uiview_desc_movie.setText(movieDetail.overview)

        val format = SimpleDateFormat("yyy-MM-dd")
        uiview_release_date_movie.setText(format.format(movieDetail.releaseDate))

        Picasso.get()
            .load(Constant.BASE_URL_IMAGE + movieDetail.posterPath)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(uiview_image_movie)

    }

    override fun erroState() {
        Toast.makeText(applicationContext,"Something error", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoadingState() {
        layout_loading_state.visibility = View.GONE
        container_movie_detail.visibility = View.VISIBLE
    }

    override fun showLoadingState() {
        layout_loading_state.visibility = View.VISIBLE
        container_movie_detail.visibility = View.GONE
    }

    override fun resolveDaggerDependency() {
        DaggerMovieDetailActivityComponent.builder()
            .applicationComponent(applicationComponent())
            .movieDetailActivityModule(MovieDetailActivityModule(this))
            .build().inject(this)
    }
}
