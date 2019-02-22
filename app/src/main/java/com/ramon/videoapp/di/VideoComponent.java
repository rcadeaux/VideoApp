package com.ramon.videoapp.di;

import com.ramon.videoapp.movie.DiscoverMovieFragment;
import com.ramon.videoapp.movie.MovieDetailsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MovieDbModule.class,YoutubeModule.class})
public interface VideoComponent {
    void inject(DiscoverMovieFragment discoverMovieFragment);
    void inject(MovieDetailsFragment movieDetailsFragment);
}
