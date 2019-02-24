package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.movie.MovieDbEndpoint;
import com.ramon.videoapp.webservices.movie.models.MovieResult;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

class MovieDetailsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_poster)
    ImageView moviePoster;
    @BindView(R.id.movie_overview)
    TextView movieOverview;
    @BindView(R.id.movie_title)
    TextView movieTitle;

    private MovieDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_details_vh,viewGroup,false);
        return  new MovieDetailsViewHolder(view);
    }

    void bind(MovieResult movieResult) {
        Picasso.get()
                .load(MovieDbEndpoint.getMovieImageEndpoint(movieResult.getPosterPath()))
                .placeholder(R.drawable.ic_mood_black_24dp)
                .error(R.drawable.image_download_failed)
                .into(moviePoster);
        movieOverview.setText(movieResult.getOverview());
        movieTitle.setText(movieResult.getTitle());

    }
}
