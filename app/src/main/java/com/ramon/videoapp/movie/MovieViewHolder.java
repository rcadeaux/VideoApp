package com.ramon.videoapp.movie;

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
import butterknife.OnClick;

class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_image)
    ImageView movieImage;
    @BindView(R.id.movie_title)
    TextView movieTitleTextView;

    private final ItemClickedListener listener;
    private MovieResult movieResults;

    private MovieViewHolder(@NonNull View itemView, ItemClickedListener listner) {
        super(itemView);
        this.listener=listner;
        ButterKnife.bind(this,itemView);
    }

    static RecyclerView.ViewHolder inflate(ViewGroup viewGroup, ItemClickedListener listener) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discover_movie_vh,viewGroup,false);
        return new MovieViewHolder(view,listener);
    }

    void bind(MovieResult movieResult){
        this.movieResults=movieResult;
        movieTitleTextView.setText(movieResult.getTitle());
        Picasso.get()
                .load(MovieDbEndpoint.getMovieImageEndpoint(movieResult.getPosterPath()))
                .placeholder(R.drawable.ic_mood_black_24dp)
                .error(R.drawable.image_download_failed)
                .into(movieImage);

    }

    @OnClick({R.id.movie_click_area,R.id.more_click_area})
    void itemClicked(){
        listener.itemClicked(movieResults);
    }
}
