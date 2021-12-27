package com.example.programmingquotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {

    private final static String BASE_API_URL = "https://programming-quotes-api.herokuapp.com/";
    private static Retrofit mRetrofit = null;
    private static final Gson gson = new GsonBuilder().create();

    private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private static final OkHttpClient okHttpClient = okHttpClientBuilder.build();

    public static <T> T createRetrofitService(Class<T> serviceClass) {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(BASE_API_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        }
        return mRetrofit.create(serviceClass);
    }
}
