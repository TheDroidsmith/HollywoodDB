package com.droidsmith.hollywooddb.data.remote.request;




import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMovies;
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
