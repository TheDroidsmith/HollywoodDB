package com.droidsmith.hollywooddb.injection.module;

import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build();

        return retrofit;
    }

    @Provides
    TMDBService provideMovieInterface(Retrofit retrofit){
        return retrofit.create(TMDBService.class);
    }


}
