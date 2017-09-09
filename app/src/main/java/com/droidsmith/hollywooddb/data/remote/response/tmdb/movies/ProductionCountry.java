package com.droidsmith.hollywooddb.data.remote.response.tmdb.movies;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ProductionCountry {

    @SerializedName("iso_3166_1")
    @Expose
    public String iso31661;
    @SerializedName("name")
    @Expose
    public String name;

}
