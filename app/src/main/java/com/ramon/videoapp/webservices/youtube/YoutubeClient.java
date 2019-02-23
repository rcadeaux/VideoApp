package com.ramon.videoapp.webservices.youtube;

import android.app.Application;

import com.ramon.videoapp.webservices.movie.models.MovieResult;
import com.ramon.videoapp.webservices.youtube.callbacks.YoutubeCallbacks;
import com.ramon.videoapp.webservices.youtube.models.YoutubeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeClient {

    private final Application app;
    private final YoutubeApi client;

   private static final String API_KEY = "AIzaSyBdDTZNgpEcT-akxeV6M7oURAdZcK-UXmI";
    private static final String PART = "snippet";
    private static final String TYPE = "video";
    private static final String CAPTION = "closedCaption";
    private static final int MAX_RESULT = 5;

    public YoutubeClient(Application app, YoutubeApi client) {
        this.app = app;
        this.client = client;

    }

    public void getYoutubeVideos(final YoutubeCallbacks callbacks, MovieResult result) {
        client.getYoutubeVideos(API_KEY, PART, TYPE, result.getTitle(), CAPTION,MAX_RESULT).enqueue(new Callback<YoutubeResponse>() {
            @Override
            public void onResponse(Call<YoutubeResponse> call, Response<YoutubeResponse> response) {
                if (response.isSuccessful()) {
                    callbacks.youtubeVideoList(response.body());

                } else {
                    callbacks.youtubeLookupFailed(response.code(), response.message());
                }

            }

            @Override
            public void onFailure(Call<YoutubeResponse> call, Throwable t) {
                callbacks.youtubeLookupFailed(-1, t.getMessage());

            }
        });
    }
}
