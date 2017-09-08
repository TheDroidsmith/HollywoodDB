package com.droidsmith.hollywooddb.model.network;




import com.droidsmith.hollywooddb.model.network.gson.Movie;
import com.droidsmith.hollywooddb.model.network.gson.PopularMovies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBInterface {

    @GET("movie/{id}")
    Call<Movie> doGetMovie(@Path("id") Integer movieID, @Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<PopularMovies> doGetPopularMovies(@Query("api_key") String apiKey);




}
