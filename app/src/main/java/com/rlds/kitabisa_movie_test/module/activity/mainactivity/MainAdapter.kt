package com.rlds.kitabisa_movie_test.module.activity.mainactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.rlds.kitabisa_movie_test.R
import com.rlds.kitabisa_movie_test.constant.Constant
import com.rlds.kitabisa_movie_test.model.Movie
import com.rlds.kitabisa_movie_test.model.MovieResult
import com.rlds.kitabisa_movie_test.module.activity.detailactivity.DetailMovieActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie__viewholder.view.*
import java.text.SimpleDateFormat

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    var initMovie:Movie? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie__viewholder,
            parent, false)
        return MainViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return initMovie?.result!!.size
    }

    fun addData(movie: Movie) {

        if(initMovie !=null) {
            initMovie = null
        }

        initMovie = movie

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(initMovie!!.result[position])
    }
}

class MainViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val myContext: Context

    private var myMovie: MovieResult? = null

    init {
        itemView.item_movie.setOnClickListener(this)

        myContext = context
    }


    private val uiViewImageMovie: ImageView by lazy {
        itemView.findViewById(R.id.uiview_image_movie) as ImageView
    }

    private val uiViewTitleMovie: TextView by lazy {
        itemView.findViewById(R.id.uiview_title_movie) as TextView
    }

    private val uiViewDescMovie: TextView by lazy {
        itemView.findViewById(R.id.uiview_desc_movie) as TextView
    }

    private val uiViewReleaseDateMovie: TextView by lazy {
        itemView.findViewById(R.id.uiview_release_date_movie) as TextView
    }

    fun onBind(movie: MovieResult) {

        myMovie = movie

        Picasso.get()
            .load(Constant.BASE_URL_IMAGE + movie.posterPath)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(uiViewImageMovie)

        uiViewTitleMovie.setText(movie.title)
        uiViewDescMovie.setText(movie.overview)

        val format = SimpleDateFormat("yyy-MM-dd")
        uiViewReleaseDateMovie.setText(format.format(movie.releaseDate))
    }

    override fun onClick(v: View?) {

        myMovie?.id?.let {
            DetailMovieActivity.intentOpenMovieDetail(myContext,it)
        }

    }
}