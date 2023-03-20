package com.codepath.articlesearch

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var posterImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var adultRatingTextView: TextView
    private lateinit var popularityTextView: TextView
    private lateinit var voteAverageTextView: TextView
    private lateinit var voteCountTextView: TextView
    private lateinit var overviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Find the views for the screen
        posterImageView = findViewById(R.id.poster)
        nameTextView = findViewById(R.id.name)
        adultRatingTextView = findViewById(R.id.adultRating)
        popularityTextView = findViewById(R.id.popularity)
        voteAverageTextView = findViewById(R.id.voteAverage)
        voteCountTextView = findViewById(R.id.voteCount)
        overviewTextView = findViewById(R.id.overview)

        // Get the extra from the Intent
        val show = intent.getSerializableExtra(SHOW_EXTRA) as Show

        // Set the info for show
        nameTextView.text = show.name

        if(show.adult == true){
            adultRatingTextView.text = "This show is rated for Adults Only"
        } else {
            adultRatingTextView.text = "This show is Not Adult Rated"
        }

        popularityTextView.text = "Popularity: ${show.popularity}"
        voteAverageTextView.text = "Vote Average: ${show.voteAverage}"
        voteCountTextView.text = "Vote Count: ${show.voteCount}"
        overviewTextView.text = show.overview


        // Load the show poster
        Glide.with(this)
            .load(show.posterURL)
            .into(posterImageView)

        // make overview scrollable
//        overviewTextView.movementMethod = ScrollingMovementMethod()

    }
}