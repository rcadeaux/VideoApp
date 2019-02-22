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

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.YoutubeEndpoint;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

class RelatedVideoViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.youtube_vid)
    VideoView videoView;
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
//        testLink.setText(YoutubeEndpoint.getWatchUrl(youtubeItem.getId().getVideoId()));
        MediaController mediaController= new MediaController(itemView.getContext());
        mediaController.setMediaPlayer(videoView);
        mediaController.setAnchorView(videoView);
        videoView.setVideoURI( Uri.parse(YoutubeEndpoint.getWatchUrl(youtubeItem.getId().getVideoId())));
    }

    @OnClick(R.id.youtube_vid)
    public void videoPlayer(){

    }
}
