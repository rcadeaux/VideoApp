package com.ramon.videoapp.movie;

import com.ramon.videoapp.webservices.movie.models.MovieResult;

interface ItemClickedListener {
    void itemClicked(MovieResult movieResults);
}
