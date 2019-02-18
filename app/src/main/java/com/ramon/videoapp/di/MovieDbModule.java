package com.ramon.videoapp.di;

import android.app.Application;

import com.ramon.videoapp.webservices.configuration.InterceptorConfig;
import com.ramon.videoapp.webservices.configuration.OkHttpManagerConfig;
import com.ramon.videoapp.webservices.configuration.UnsafeHostnameVerifierConfig;
import com.ramon.videoapp.webservices.configuration.UnsafeTrustManagerConfig;
import com.ramon.videoapp.webservices.movie.MovieDbApi;
import com.ramon.videoapp.webservices.movie.MovieDbClient;
import com.ramon.videoapp.webservices.movie.MovieDbEndpoint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CertificatePinner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MovieDbModule {

    private Application app;

    public MovieDbModule(Application app) {
        this.app = app;
    }

    @Provides
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public MovieDbClient provideSolidApiClient(Application app, MovieDbApi client) {
        return new MovieDbClient(app, client);
    }

    @Provides
    @Singleton
    public MovieDbApi provideSolidApi(OkHttpManagerConfig okHttpManager, GsonConverterFactory factory, MovieDbEndpoint endpoint) {
        return new Retrofit.Builder()
                .client(okHttpManager.getOkHttpClient())
                .addConverterFactory(factory)
                .baseUrl(endpoint.getEndpoint())
                .build()
                .create(MovieDbApi.class);
    }

    @Provides
    @Singleton
    public MovieDbEndpoint providesSolidEndpoint() {
        return new MovieDbEndpoint();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideConverterFactory() {
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    public OkHttpManagerConfig provideSolidOkHttpManager(UnsafeTrustManagerConfig unsafeTrustManager, CertificatePinner certificatePinner,
                                                         InterceptorConfig interceptor,  UnsafeHostnameVerifierConfig unsafeHostnameVerifier) {
        return new OkHttpManagerConfig(unsafeTrustManager, certificatePinner, interceptor, unsafeHostnameVerifier);
    }

    @Provides
    @Singleton
    public CertificatePinner providesCertificatePinner() {
        return new CertificatePinner.Builder()

                .build();
    }

    @Provides
    @Singleton
    public UnsafeTrustManagerConfig provideUnsafeCertificateValidator() {
        return new UnsafeTrustManagerConfig();
    }

    @Provides
    @Singleton
    public UnsafeHostnameVerifierConfig providesUnsafeHostnameVerifier() {
        return new UnsafeHostnameVerifierConfig();
    }

    @Provides
    @Singleton
    public InterceptorConfig provideInterceptor() {
        return new InterceptorConfig();
    }



}
