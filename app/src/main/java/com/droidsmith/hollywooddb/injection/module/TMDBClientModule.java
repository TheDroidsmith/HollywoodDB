package com.droidsmith.hollywooddb.injection.module;

import android.app.Application;

import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TMDBClientModule {

    private static final String BASE_URL ="https://api.themoviedb.org/3/";

    @Provides
    OkHttpClient provideHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient client){
        @SuppressWarnings("Redundancy")
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    @Provides
    TMDBInterface provideMovieInterface(Retrofit retrofit){
        return retrofit.create(TMDBInterface.class);
    }


}
