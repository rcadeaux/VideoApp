package com.ramon.videoapp.webservices.movie;

public class MovieDbEndpoint {

    public String getEndpoint() {
        return "https://api.themoviedb.org/3/";
    }

    public static String getMovieImageEndpoint(String endpoint) {
        return "https://image.tmdb.org/t/p/w500/"+endpoint;
    }
}
