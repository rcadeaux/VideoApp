package com.ramon.videoapp.webservices.configuration;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Interceptor;
import okhttp3.Response;

public class InterceptorConfig implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //TODO: Intercept errors from Service
        Response response = chain.proceed(chain.request());
        switch (response.code()) {
            case HttpsURLConnection.HTTP_UNAUTHORIZED:
                break;
            case HttpURLConnection.HTTP_UNAVAILABLE:
                break;
            case HttpURLConnection.HTTP_FORBIDDEN:
                break;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                break;
        }
        return response;
    }
}