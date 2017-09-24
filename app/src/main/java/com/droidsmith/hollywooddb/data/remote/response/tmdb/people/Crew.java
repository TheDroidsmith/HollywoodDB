package com.droidsmith.hollywooddb.data.remote.response.tmdb.people;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crew {
    @SerializedName("credit_id")
    @Expose
    public String creditId;
    @SerializedName("department")
    @Expose
    public String department;
    @SerializedName("gender")
    @Expose
    public Integer gender;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("job")
    @Expose
    public String job;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("profile_path")
    @Expose
    public Object profilePath;
}
