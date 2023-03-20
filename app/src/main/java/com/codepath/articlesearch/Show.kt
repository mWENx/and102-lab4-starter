package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Keep
//@Serializable
//data class SearchShowsResponse(
//    @SerialName("response")
//    val response: BaseResponse?
//)


//JSON parsing step 1: results, list of JSON objects
@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val results: List<Show>?
)

//Step 2: Show objects

@Keep
@Serializable
data class Show(

    @SerialName("adult")
    val adult: Boolean?,

    //main page
    @SerialName("name")
    val name: String?,

    @SerialName("overview")
    val overview: String?,

    //main page
    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("popularity")
    val popularity: Float?,

    //main page
    @SerialName("vote_average")
    val voteAverage: Float?,

    @SerialName("vote_count")
    val voteCount: Int?

) : java.io.Serializable {
    val posterURL = "https://image.tmdb.org/t/p/w500/${posterPath}"
}
