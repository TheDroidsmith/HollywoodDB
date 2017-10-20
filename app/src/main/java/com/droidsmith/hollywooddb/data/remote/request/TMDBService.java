package com.droidsmith.hollywooddb.data.remote.request;




import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.NowPlayingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.TopMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.CreditResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShowDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBService {

    //movies
    @GET("movie/popular")
    Single<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/latest")
    Single<LatestMoviesResponse> getLatestMovies(@Query("api_key") String apiKey);//TODO: remove this

    @GET("movie/upcoming")
    Single<UpcomingMoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Single<TopMoviesResponse> getTopMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Single<NowPlayingMoviesResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Single<MovieDetails> getMovieDetails(@Path("id") Integer movieID, @Query("api_key") String apiKey);

    @GET("movie/{id}/credits")
    Single<CreditResponse> getMovieCredits(@Path("id") Integer movieID, @Query("api_key") String apiKey);


    //TV
    @GET("tv/popular")
    Single<PopularTVResponse> getPopularTV(@Query("api_key") String apiKey);

    @GET("tv/top_rated")
    Single<TopTVResponse> getTopTV(@Query("api_key") String apiKey);

    @GET("tv/airing_today")
    Single<AiringTodayResponse> getAiringTodayTV(@Query("api_key") String apiKey);

    @GET("tv/on_the_air")
    Single<OnTheAirResponse> getOnTheAirTV(@Query("api_key") String apiKey);

    @GET("tv/{id}")
    Single<TVShowDetails> getTVShowDetails(@Path("id") Integer tvID, @Query("api_key") String apiKey);

    @GET("tv/{id}/credits")
    Single<CreditResponse> getTVCredits(@Path("id") Integer tvID, @Query("api_key") String apiKey);


}
