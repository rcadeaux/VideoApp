package com.ramon.videoapp.movie;

import com.ramon.videoapp.Session;
import com.ramon.videoapp.webservices.movie.MovieDbClient;
import com.ramon.videoapp.webservices.movie.models.DiscoverResults;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class MovieDataSource extends PageKeyedDataSource<Integer, DiscoverResults> {

    private final MovieDbClient client;
    private final Session session;

    public MovieDataSource(MovieDbClient client, Session session) {
        this.client=client;
        this.session=session;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, DiscoverResults> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DiscoverResults> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DiscoverResults> callback) {

    }
}
