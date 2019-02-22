package com.ramon.videoapp.movie;


import android.view.ViewGroup;

import com.ramon.videoapp.webservices.movie.models.Result;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends PagedListAdapter<Result, RecyclerView.ViewHolder> {


    protected MovieAdapter(@NonNull DiffUtil.ItemCallback<Result> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
