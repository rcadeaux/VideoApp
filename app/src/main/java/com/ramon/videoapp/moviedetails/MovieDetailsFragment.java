package com.ramon.videoapp.moviedetails;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ramon.videoapp.BaseApplication;
import com.ramon.videoapp.R;
import com.ramon.videoapp.webservices.movie.models.MovieResult;
import com.ramon.videoapp.webservices.youtube.YoutubeClient;
import com.ramon.videoapp.webservices.youtube.callbacks.YoutubeCallbacks;
import com.ramon.videoapp.webservices.youtube.models.YoutubeResponse;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsFragment extends Fragment implements YoutubeCallbacks {

    @Inject
    YoutubeClient youtubeClient;
    @Inject
    Gson gson;

    @BindView(R.id.movie_details)
    RecyclerView recyclerView;

    MovieResult result;

    private static final String SELECTED_MOVIE = "movie";


    public MovieDetailsFragment() {
        BaseApplication.getDaggerComponent().inject(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param movieItemString Json string for selected movie.
     * @return A new instance of fragment MovieDetailsFragment.
     */

    public static MovieDetailsFragment newInstance(String movieItemString) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putString(SELECTED_MOVIE, movieItemString);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        result = getMovieSelected();
        recyclerView.setAdapter(new MovieDetailsAdapter(result,null));
        youtubeClient.getYoutubeVideos(this, result);
    }


    //method to get the selected out of the argument bundle, if the string is empty, a new object is returned
    private MovieResult getMovieSelected() {
        String resultString = getArguments().getString(SELECTED_MOVIE, "");
        MovieResult result = new MovieResult();
        if (!StringUtils.isEmpty(resultString)) {
            result = gson.fromJson(resultString, MovieResult.class);
        }
        return result;
    }


    @Override
    public void youtubeVideoList(YoutubeResponse body) {

    }

    @Override
    public void youtubeLookupFailed(int code, String message) {

    }
}
