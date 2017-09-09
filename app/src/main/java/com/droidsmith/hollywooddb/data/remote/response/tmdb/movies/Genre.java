package com.droidsmith.hollywooddb.data.remote.response.tmdb.movies;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Genre {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;

}
