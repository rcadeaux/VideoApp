package com.ramon.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ramon.videoapp.movie.DiscoverMovieFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(DiscoverMovieFragment.newInstance(),"discover")
                .commit();

    }
}
