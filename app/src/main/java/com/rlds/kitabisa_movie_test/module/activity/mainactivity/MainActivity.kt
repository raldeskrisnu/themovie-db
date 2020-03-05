package com.rlds.kitabisa_movie_test.module.activity.mainactivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.rlds.kitabisa_movie_test.R
import com.rlds.kitabisa_movie_test.di.component.DaggerMainActivityComponent
import com.rlds.kitabisa_movie_test.module.base.BaseActivity
import com.rlds.kitabisa_movie_test.module.presenter.MainPresenter
import com.rlds.kitabisa_movie_test.module.view.MainView
import javax.inject.Inject
import com.rlds.kitabisa_movie_test.di.module.MainActivityModule
import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieDbRealm
import io.realm.Realm
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainView {

    var mainPresenter: MainPresenter? = null
        @Inject set

    lateinit var realm: Realm

    private val mainAdapter: MainAdapter by lazy {
        val adapter = MainAdapter(this)

        uiView_recylerview_movie.adapter = adapter

        uiView_recylerview_movie.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)

        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        mainPresenter?.getPopulerMovie()

        realm = Realm.getDefaultInstance()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_populer -> {
                mainPresenter?.getPopulerMovie()
                return true
            }

            R.id.action_now_playing -> {
                mainPresenter?.getNowPlayingMovie()
                return true
            }

            R.id.action_top_rated -> {
                mainPresenter?.getTopRatedMovie()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun getPopulerMovies(movie: Movie) {

        mainAdapter.addData(movie)
        var movieDbRealm: MovieDbRealm = MovieDbRealm()

        movie.result.forEach {
            movieDbRealm?.setId(it.id)
            movieDbRealm?.setMovieDesc(it.overview)
        }

        mainPresenter?.saveMovieLocal(movieDbRealm,realm)
    }

    override fun getNowPlayingMovies(movie: Movie) {
        mainAdapter.addData(movie)
    }

    override fun getTopRatedMovies(movie: Movie) {
        mainAdapter.addData(movie)
    }

    override fun showLoadingState() {
        layout_loading_state.visibility = View.VISIBLE
        uiView_recylerview_movie.visibility = View.GONE
    }

    override fun hideLoadingState() {
        layout_loading_state.visibility = View.GONE
        uiView_recylerview_movie.visibility = View.VISIBLE
    }

    override fun erroState() {
        Toast.makeText(applicationContext,"Something error",Toast.LENGTH_SHORT).show()
    }

    override fun resolveDaggerDependency() {
        DaggerMainActivityComponent.builder()
            .applicationComponent(applicationComponent())
            .mainActivityModule(MainActivityModule(this))
            .build().inject(this)
    }
    
}
