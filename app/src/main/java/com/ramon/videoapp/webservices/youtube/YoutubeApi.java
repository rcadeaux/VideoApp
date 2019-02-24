package com.ramon.videoapp.webservices.youtube;

import com.ramon.videoapp.webservices.youtube.models.YoutubeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    @GET("search")
    Call<YoutubeResponse> getYoutubeVideos(@Query("key") String apiKey,
                                           @Query("part") String part,
                                           @Query("type") String type,
                                           @Query("q") String searchQuery,
                                           @Query("videoCaption") String caption,
                                           @Query("maxResults") int maxResult);
}
