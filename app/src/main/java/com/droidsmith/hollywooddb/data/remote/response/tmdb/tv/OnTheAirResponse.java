package com.droidsmith.hollywooddb.data.remote.response.tmdb.tv;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OnTheAirResponse {
    @SerializedName("results")
    @Expose
    public List<TVShow> results = null;
}
