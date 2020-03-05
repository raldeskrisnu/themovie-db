package com.rlds.kitabisa_movie_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import java.io.Serializable
import java.util.*

data class Movie (

    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("results")
    @Expose
    var result : List<MovieResult>

) : Serializable

data class MovieResult(

    @SerializedName("popularity")
    @Expose
    var popularity: Double,

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int,

    @SerializedName("poster_path")
    @Expose
    var posterPath: String,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("adult")
    @Expose
    var adult: Boolean,

    @SerializedName("original_title")
    @Expose
    var originalTitle: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("release_date")
    @Expose
    var releaseDate: Date

): Serializable