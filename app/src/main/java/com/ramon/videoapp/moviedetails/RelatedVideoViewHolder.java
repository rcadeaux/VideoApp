package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;

class RelatedVideoViewHolder extends RecyclerView.ViewHolder {
    public RelatedVideoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.related_videos_vh,viewGroup,false);
        return new RelatedVideoViewHolder(view);
    }

    public void bind(YoutubeItem youtubeItem) {

    }
}