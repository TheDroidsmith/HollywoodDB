package com.droidsmith.hollywooddb.model.network.gson;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class BelongsToCollection {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;

}
