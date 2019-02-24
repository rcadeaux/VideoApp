package com.ramon.videoapp.webservices.movie.callback;

import com.ramon.videoapp.webservices.movie.models.DiscoverResults;

public interface MovieListCallback {
    void onMovieSuccess(DiscoverResults body);
    void onMovieFailure(int code, String message);
}
