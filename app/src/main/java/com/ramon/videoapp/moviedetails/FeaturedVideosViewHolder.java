package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeaturedVideosViewHolder extends RecyclerView.ViewHolder {

    private final YoutubeItemClicked clickListener;
    @BindView(R.id.now_playing)
    TextView nowPlayingText;
    @BindView(R.id.youtube_title)
    TextView youtubeTitle;
    @BindView(R.id.thumbnail_preview)
    ImageView posterImage;
    private YoutubeItem youtubeItem;

    public FeaturedVideosViewHolder(@NonNull View itemView, YoutubeItemClicked clickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListener=clickListener;
    }

    static FeaturedVideosViewHolder inflate(ViewGroup viewGroup,YoutubeItemClicked clickListener) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.more_videos_vh, viewGroup, false);
        return new FeaturedVideosViewHolder(view,clickListener);
    }

    void bind(@NonNull YoutubeItem item, boolean nowPlaying) {
        this.youtubeItem=item;
        youtubeTitle.setText(item.getSnippet().getTitle());
        nowPlayingText.setVisibility(nowPlaying ? View.VISIBLE : View.GONE);
        Picasso.get()
                .load(item.getSnippet().getThumbnails().getDefault().getUrl())
                .placeholder(R.drawable.ic_mood_black_24dp)
                .error(R.drawable.image_download_failed)
                .into(posterImage);

    }

    @OnClick(R.id.related_click_area)
    public void clickArea(){
        clickListener.itemClicked(youtubeItem);
    }
}
