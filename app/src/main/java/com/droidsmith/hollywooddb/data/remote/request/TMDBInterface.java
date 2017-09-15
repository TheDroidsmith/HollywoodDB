package com.droidsmith.hollywooddb.data.remote.request;




import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBInterface {

    //movies
    @GET("movie/popular")
    Observable<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/latest")
    Observable<LatestMoviesResponse> getLatestMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Observable<UpcomingMoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<Movie> doGetMovie(@Path("id") Integer movieID, @Query("api_key") String apiKey);


    //TV
    @GET("tv/popular")
    Observable<PopularTVResponse> getPopularTV(@Query("api_key") String apiKey);

    @GET("tv/top_rated")
    Observable<TopTVResponse> getTopRatedTV(@Query("api_key") String apiKey);



}
