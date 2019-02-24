package com.ramon.videoapp.webservices.youtube.callbacks;

import com.ramon.videoapp.webservices.youtube.models.YoutubeResponse;

public interface YoutubeCallbacks {
    void youtubeVideoList(YoutubeResponse body);
    void youtubeLookupFailed(int code, String message);
}
