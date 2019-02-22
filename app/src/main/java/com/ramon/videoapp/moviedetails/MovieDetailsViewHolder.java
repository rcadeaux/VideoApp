package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.movie.models.MovieResult;

class MovieDetailsViewHolder extends RecyclerView.ViewHolder {

    public MovieDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_details_vh,viewGroup,false);
        return  new MovieDetailsViewHolder(view);
    }

    public void bind(MovieResult movieResult) {

    }
}
