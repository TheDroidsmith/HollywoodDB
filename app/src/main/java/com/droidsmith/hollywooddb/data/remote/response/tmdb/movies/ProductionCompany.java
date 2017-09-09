package com.droidsmith.hollywooddb.data.remote.response.tmdb.movies;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ProductionCompany {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id")
    @Expose
    public Integer id;

}
