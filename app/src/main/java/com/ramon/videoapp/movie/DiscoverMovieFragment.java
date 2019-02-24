package com.ramon.videoapp.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.ramon.videoapp.BaseApplication;
import com.ramon.videoapp.R;
import com.ramon.videoapp.Session;
import com.ramon.videoapp.moviedetails.MovieDetailsFragment;
import com.ramon.videoapp.webservices.movie.MovieDbClient;
import com.ramon.videoapp.webservices.movie.callback.MovieListCallback;
import com.ramon.videoapp.webservices.movie.models.DiscoverResults;
import com.ramon.videoapp.webservices.movie.models.MovieResult;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DiscoverMovieFragment extends Fragment implements MovieListCallback, ItemClickedListener {

    @Inject
    MovieDbClient movieDbClient;
    @Inject
    Session session;
    @Inject
    Gson gson;

    @BindView(R.id.movie_rv)
    RecyclerView movies;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.empty_view)
    ConstraintLayout emptyView;
    @BindView(R.id.error_view)
    ConstraintLayout errorView;

    GridLayoutManager gridLayoutManager;
    private MovieAdapter adapter;
    private Integer maxPage;


    public DiscoverMovieFragment() {
        BaseApplication.getDaggerComponent().inject(this);
    }

    public static DiscoverMovieFragment newInstance() {
        DiscoverMovieFragment fragment = new DiscoverMovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        movieDbClient.getDiscoverList(this, session.getPageNumber());
        movies.setLayoutManager(new GridLayoutManager(getContext(), 3));
        movies.addOnScrollListener(scrollListener);

    }

    private void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onMovieSuccess(DiscoverResults body) {
        hideProgressDialog();
        if (session.getLoadingMoreData()) {
            session.setLoadingMoreData(false);
            adapter.addAllMovies(body.getMovieResults());
        } else {
            if (!body.getMovieResults().isEmpty()) {
                movies.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);
                errorView.setVisibility(View.GONE);
                adapter = new MovieAdapter(this, body.getMovieResults());
                movies.setAdapter(adapter);
                maxPage = body.getTotalPages();
            } else {
                showEmptyPage();
            }
        }

    }

    private void showEmptyPage() {
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        movies.setVisibility(View.GONE);
    }


    @Override
    public void onMovieFailure(int code, String message) {
        hideProgressDialog();
        showErrorScreen();

    }

    private void showErrorScreen() {
        //error in the webservice, show message to prevent user anger
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        movies.setVisibility(View.GONE);

    }

    @Override
    public void itemClicked(MovieResult movieResults) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MovieDetailsFragment.newInstance(gson.toJson(movieResults)))
                    .addToBackStack("detailsFrag")
                    .commit();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext()!=null? getContext():getActivity());
            alertDialog.setMessage(getString(R.string.something_bad_happened));
            alertDialog.setPositiveButton(getString(R.string.positive_btn), (dialogInterface, i) -> dialogInterface.dismiss());
            alertDialog.create().show();


        }

    }

    @OnClick(R.id.retry_btn_clicked)
    public void retryClicked() {
        movieDbClient.getDiscoverList(this, session.getPageNumber());
    }

    protected RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            GridLayoutManager linearLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();

            if (linearLayoutManager != null && movies.getAdapter() != null &&
                    session.getPageNumber() <= maxPage && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movies.getAdapter().getItemCount() - 1) {
                //bottom of list!
                loadMore();

            }
        }
    };

    private void loadMore() {
        session.incrementPageNumber();
        progressBar.setVisibility(View.VISIBLE);
        session.setLoadingMoreData(true);
        movieDbClient.getDiscoverList(this, session.getPageNumber());

    }
}
