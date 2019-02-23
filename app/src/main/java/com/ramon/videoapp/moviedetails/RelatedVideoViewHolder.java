package com.ramon.videoapp.moviedetails;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.YoutubeClient;
import com.ramon.videoapp.webservices.youtube.YoutubeEndpoint;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

class RelatedVideoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.youtube_player)
    YouTubePlayerView playerView;
    public RelatedVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.related_videos_vh,viewGroup,false);
        return new RelatedVideoViewHolder(view);
    }

    public void bind(final YoutubeItem youtubeItem) {
        playerView.initialize(YoutubeClient.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(youtubeItem.getId().getVideoId());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


    }


}
