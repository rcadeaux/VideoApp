package com.ramon.videoapp.moviedetails;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.YoutubeEndpoint;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

class RelatedVideoViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.youtube_vid)
    PlayerView videoView;
    private SimpleExoPlayer player;

    //    @BindView(R.id.link)
//    TextView testLink;
    public RelatedVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.related_videos_vh,viewGroup,false);
        return new RelatedVideoViewHolder(view);
    }

    public void bind(YoutubeItem youtubeItem) {


    }



}
