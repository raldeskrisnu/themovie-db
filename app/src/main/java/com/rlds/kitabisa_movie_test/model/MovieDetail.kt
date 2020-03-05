package com.rlds.kitabisa_movie_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class MovieDetail(

    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null,

    @SerializedName("backdrop_path")
    @Expose
    var backDropPath: String? = null,

    @SerializedName("budget")
    @Expose
    var budget: Number? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("imdb_id")
    @Expose
    var imdbId: String? = null,

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null,

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null,

    @SerializedName("release_date")
    @Expose
    var releaseDate: Date,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("results")
    @Expose
    var result : List<ProductionCompanies>

) : Serializable


data class ProductionCompanies (

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("logo_path")
    @Expose
    var logoPath: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("origin_country")
    @Expose
    var country: String? = null

): Serializable



