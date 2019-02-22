package com.ramon.videoapp.webservices.youtube;

import android.app.Application;

import com.ramon.videoapp.movie.MovieDetailsFragment;
import com.ramon.videoapp.webservices.movie.models.MovieResult;
import com.ramon.videoapp.webservices.youtube.callbacks.YoutubeCallbacks;
import com.ramon.videoapp.webservices.youtube.models.YoutubeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeClient {

    private final Application app;
    private final YoutubeApi client;

    static final String API_KEY="";
    static final String PART="snippet";
    static final String TYPE="video";
    static final String CAPTION="closedCaption";


    public YoutubeClient(Application app, YoutubeApi client) {
        this.app=app;
        this.client=client;

    }

    public void getYoutubeVideos(YoutubeCallbacks callbacks, MovieResult result) {
        client.getYoutubeVideos(API_KEY,PART,TYPE,result.getTitle(),CAPTION).enqueue(new Callback<YoutubeResponse>() {
            @Override
            public void onResponse(Call<YoutubeResponse> call, Response<YoutubeResponse> response) {

            }

            @Override
            public void onFailure(Call<YoutubeResponse> call, Throwable t) {

            }
        });
    }
}
