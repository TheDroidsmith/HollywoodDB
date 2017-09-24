package com.droidsmith.hollywooddb.data.remote.response.tmdb.people;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cast {
    @SerializedName("cast_id")
    @Expose
    public Integer castId;
    @SerializedName("character")
    @Expose
    public String character;
    @SerializedName("credit_id")
    @Expose
    public String creditId;
    @SerializedName("gender")
    @Expose
    public Integer gender;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("order")
    @Expose
    public Integer order;
    @SerializedName("profile_path")
    @Expose
    public Object profilePath;
}
