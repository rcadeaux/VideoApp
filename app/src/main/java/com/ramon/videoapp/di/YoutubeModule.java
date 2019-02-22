package com.ramon.videoapp.di;

import android.app.Application;

import com.ramon.videoapp.webservices.configuration.InterceptorConfig;
import com.ramon.videoapp.webservices.configuration.OkHttpManagerConfig;
import com.ramon.videoapp.webservices.configuration.UnsafeHostnameVerifierConfig;
import com.ramon.videoapp.webservices.configuration.UnsafeTrustManagerConfig;
import com.ramon.videoapp.webservices.youtube.YoutubeApi;
import com.ramon.videoapp.webservices.youtube.YoutubeClient;
import com.ramon.videoapp.webservices.youtube.YoutubeEndpoint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CertificatePinner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class YoutubeModule {


    public YoutubeModule(){
    }

    @Provides
    @Singleton
    public YoutubeClient provideYoutubeClient(Application app, YoutubeApi client) {
        return new YoutubeClient(app, client);
    }

    @Provides
    @Singleton
    public YoutubeApi provideYoutubeApi(OkHttpManagerConfig okHttpManager, GsonConverterFactory factory, YoutubeEndpoint endpoint) {
        return new Retrofit.Builder()
                .client(okHttpManager.getOkHttpClient())
                .addConverterFactory(factory)
                .baseUrl(endpoint.getEndpoint())
                .build()
                .create(YoutubeApi.class);
    }

    @Provides
    @Singleton
    public YoutubeEndpoint providesYoutubeEndpoint() {
        return new YoutubeEndpoint();
    }

}
