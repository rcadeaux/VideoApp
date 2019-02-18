package com.ramon.videoapp.webservices.configuration;


import com.ramon.videoapp.BuildConfig;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class OkHttpManagerConfig {

    private UnsafeTrustManagerConfig unsafeTrustManager;
    private UnsafeHostnameVerifierConfig unsafeHostnameVerifier;
    private CertificatePinner pinner;
    private InterceptorConfig interceptor;


    public OkHttpManagerConfig(UnsafeTrustManagerConfig unsafeTrustManager, CertificatePinner certificatePinner,
                               InterceptorConfig interceptor,
                               UnsafeHostnameVerifierConfig unsafeHostnameVerifier) {
        this.unsafeTrustManager = unsafeTrustManager;
        this.unsafeHostnameVerifier = unsafeHostnameVerifier;
        this.pinner = certificatePinner;
        this.interceptor = interceptor;

    }

    public OkHttpClient getOkHttpClient() {
        try {
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();

            // Sets the user agent through Interceptor only if the string is not null and not empty
            final SSLContext sslContext = SSLContext.getInstance("TLS");

            if (BuildConfig.CERT_VALIDATION) {

                //  No changes done to OKHttp (uses system root certificates)

                if (BuildConfig.CERT_PINNING) {
                    // certificate pinning is on, so use the provided pinner instance
                    okHttpClientBuilder.certificatePinner(pinner);

                } else {

                    // Allows all certificate chains
                    sslContext.init(null, new TrustManager[]{unsafeTrustManager}, new java.security.SecureRandom());
                    okHttpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), unsafeTrustManager);

                    // Allows mismatched hostnames on the certificate
                    okHttpClientBuilder.hostnameVerifier(unsafeHostnameVerifier);

                }

            }
            return okHttpClientBuilder
                    // sets interceptor for response code handling
                    .addInterceptor(interceptor)


                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            if (BuildConfig.LOGGING_ENABLED) {
                e.printStackTrace();
            }
            return new OkHttpClient();
        }
    }

}