package com.ramon.videoapp;

import android.app.Application;

import com.ramon.videoapp.di.DaggerVideoComponent;
import com.ramon.videoapp.di.MovieDbModule;
import com.ramon.videoapp.di.VideoComponent;
import com.ramon.videoapp.di.YoutubeModule;

public class BaseApplication extends Application {

    private static VideoComponent daggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildDaggerComponent();
    }

    public void buildDaggerComponent() {
        daggerComponent= DaggerVideoComponent.builder()
                .movieDbModule(new MovieDbModule(this))
                .youtubeModule(new YoutubeModule())
                .build();
    }
    public static VideoComponent getDaggerComponent() {
        return daggerComponent;
    }


}
