package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.YoutubeClient;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;
import butterknife.ButterKnife;


class RelatedVideoViewHolder extends RecyclerView.ViewHolder {



    private RelatedVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.related_videos_vh, viewGroup, false);
        return new RelatedVideoViewHolder(view);
    }


    void bind(@NonNull final YoutubeItem youtubeItem, FragmentManager manager) {
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


       manager.beginTransaction().add(R.id.youtube_layout, youTubePlayerFragment).commit();


        youTubePlayerFragment.initialize(YoutubeClient.API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.cueVideo(youtubeItem.getId().getVideoId());

                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(itemView.getContext(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });



    }


}
