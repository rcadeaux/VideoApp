package com.ramon.videoapp.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.movie.models.MovieResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_image)
    ImageView movieImage;
    @BindView(R.id.movie_title)
    TextView moiveTitle;

    private final ItemClickedListener listener;
    private MovieResult movieResults;

    public MovieViewHolder(@NonNull View itemView, ItemClickedListener listner) {
        super(itemView);
        this.listener=listner;
        ButterKnife.bind(this,itemView);
    }

    public static RecyclerView.ViewHolder inflate(ViewGroup viewGroup, ItemClickedListener listner) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discover_movie_vh,viewGroup);
        return new MovieViewHolder(view,listner);
    }

    public void bind(MovieResult movieResult){
        this.movieResults=movieResult;
        moiveTitle.setText(movieResult.getTitle());

    }

    @OnClick({R.id.movie_click_area,R.id.movie_click_area})
    public void itemClicked(){
        listener.itemClicked(movieResults);
    }
}
