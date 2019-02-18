package com.ramon.videoapp.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MovieDbModule.class})
public interface VideoComponent {
}
