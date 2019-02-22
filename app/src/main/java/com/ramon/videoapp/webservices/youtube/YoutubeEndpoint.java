package com.ramon.videoapp.webservices.youtube;

public class YoutubeEndpoint {
    public String getEndpoint() {
        return "https://www.googleapis.com/youtube/v3/";
    }

    public static String getWatchUrl(String videoId){
        return "https://www.youtube.com/watch?v="+videoId;
    }
}
