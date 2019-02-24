package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ramon.videoapp.webservices.movie.models.MovieResult;
import com.ramon.videoapp.webservices.youtube.models.YoutubeItem;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsAdapter extends RecyclerView.Adapter {
    private static final int INFO_VH = 0;
    private static final int VIDEO_VH = 1;
    private static final int LOADING_VH = 2;
    private static final int OTHER_VH = 3;
    private final FragmentManager manager;
    private final YoutubeItemClicked clickListener;
    private List<YoutubeItem> youtubeList;
    private MovieResult movieResult;
    YoutubeItem itemclicked = null;

    MovieDetailsAdapter(MovieResult result, List<YoutubeItem> youtubeList, FragmentManager childFragmentManager,YoutubeItemClicked youtubeItemClicked) {
        this.movieResult = result;
        this.youtubeList = youtubeList;
        this.manager = childFragmentManager;
        this.clickListener=youtubeItemClicked;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == INFO_VH) {
            holder = MovieDetailsViewHolder.inflate(viewGroup);
        } else if (viewType == VIDEO_VH) {
            holder = RelatedVideoViewHolder.inflate(viewGroup);
        } else if (viewType==LOADING_VH){
            holder = LoadingViewHolder.inflate(viewGroup);
        }else {
           holder= FeaturedVideosViewHolder.inflate(viewGroup,clickListener);
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof MovieDetailsViewHolder) {
            ((MovieDetailsViewHolder) viewHolder).bind(movieResult);
        } else if (viewHolder instanceof RelatedVideoViewHolder) {
            ((RelatedVideoViewHolder) viewHolder).bind(itemclicked, manager);
        } else if (viewHolder instanceof LoadingViewHolder){
            ((LoadingViewHolder) viewHolder).bind();
        } else {
            YoutubeItem item=youtubeList.get(position - 2);

            ((FeaturedVideosViewHolder)viewHolder).bind(item,item.equals(itemclicked));
        }

    }


    //if the list is not empty then the size is the amount of videos that came back plus 1 more for the header
    // otherwise its just the size of the loading viewholder and the details one
    @Override
    public int getItemCount() {
        return youtubeList != null ? youtubeList.size() + 2 : 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return INFO_VH;
        }

        if (youtubeList != null) {
            if (position == 1) {
                return VIDEO_VH;
            } else {
                return OTHER_VH;
            }

        } else {
            youtubeList = new ArrayList<>();
            youtubeList.add(new YoutubeItem());
            return LOADING_VH;
        }
    }

    void addYoutubeVideo(List<YoutubeItem> items) {
        youtubeList.addAll(items);
        itemclicked = items.get(0);
        notifyDataSetChanged();
    }

    void removeLoadingFooter() {
        youtubeList.remove(0);
        notifyItemRemoved(1);

    }

    void showError() {

    }

    public void refresh(YoutubeItem item) {
        itemclicked = item;
        notifyDataSetChanged();

    }
}
