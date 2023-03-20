package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val SHOW_EXTRA = "SHOW_EXTRA"
private const val TAG = "ShowAdapter"

class ShowAdapter(private val context: Context, private val shows: List<Show>) :
    RecyclerView.Adapter<ShowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_show, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = shows[position]
        holder.bind(show)
    }

    override fun getItemCount() = shows.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val posterImageView = itemView.findViewById<ImageView>(R.id.poster)
        private val titleTextView = itemView.findViewById<TextView>(R.id.name)
        private val voteTextView = itemView.findViewById<TextView>(R.id.showVoteAverage)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(show: Show){
            titleTextView.text = show.name
            voteTextView.text = "Vote Average: ${show.voteAverage}"


            Glide.with(context)
                .load(show.posterURL)
                .into(posterImageView)
        }

        override fun onClick(v: View?) {
            // Get selected shows
            val show = shows[absoluteAdapterPosition]

            // Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(SHOW_EXTRA, show)
            context.startActivity(intent)
        }
    }
}