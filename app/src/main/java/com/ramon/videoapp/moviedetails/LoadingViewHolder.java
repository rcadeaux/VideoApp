package com.ramon.videoapp.moviedetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramon.videoapp.R;

class LoadingViewHolder extends RecyclerView.ViewHolder {

    private LoadingViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    static RecyclerView.ViewHolder inflate(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.loading_vh, viewGroup, false);
        return new LoadingViewHolder(view);
    }

    void bind() {

    }
}
