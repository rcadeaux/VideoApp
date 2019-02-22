package com.ramon.videoapp.di;

import com.ramon.videoapp.movie.DiscoverMovieFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MovieDbModule.class,YoutubeModule.class})
public interface VideoComponent {
    void inject(DiscoverMovieFragment discoverMovieFragment);
}
