package com.ramon.videoapp.webservices.movie;

import com.ramon.videoapp.webservices.movie.models.DiscoverResults;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbApi {
    @GET("discover/movie")
    Call<DiscoverResults> getDiscoverList(@Query("api_key") String apiKey,
                                          @Query("include_video") boolean includeVideo,
                                          @Query("page") int page);
}
