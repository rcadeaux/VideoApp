package com.ramon.videoapp.webservices.youtube;

import android.util.Log;

public class YoutubeEndpoint {
    public String getEndpoint() {
        return "https://www.googleapis.com/youtube/v3/";
    }

    public static String getWatchUrl(String videoId){
        Log.d("Youtube URL","https://www.youtube.com/watch?v="+videoId);
        return "https://www.youtube.com/watch?v="+videoId;
    }
}
