package com.droidsmith.hollywooddb.injection.module;

import android.os.Environment;

import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
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

        //TODO: figure out cache issue
//        File cacheDirectory = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File file = new File(cacheDirectory, "DemoPicture.jpg");
//
//        File customCacheDirectory = new File(
//                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile() + "/MyCache");
//
//        if(!customCacheDirectory.mkdir()){
//            customCacheDirectory.mkdirs();
//        }


        return new OkHttpClient
                .Builder()
                //.cache(new Cache(customCacheDirectory, Integer.MAX_VALUE))
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    OkHttp3Downloader provideOkHttpDownloader(OkHttpClient client){
        return new OkHttp3Downloader(client);
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
