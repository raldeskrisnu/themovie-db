package com.rlds.kitabisa_movie_test.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MovieDbRealm: RealmObject() {

    @PrimaryKey
    private var id: Int = 0

    private lateinit var movieTitle: String

    private lateinit var movieDesc: String

    fun setId(id: Int) {
        this.id = id
    }

    fun getId() : Int {
        return id
    }

    fun setMovieDesc(movieDesc: String)  {
        this.movieDesc = movieDesc
    }

    fun getMovieDesc() : String {
        return movieDesc
    }
}