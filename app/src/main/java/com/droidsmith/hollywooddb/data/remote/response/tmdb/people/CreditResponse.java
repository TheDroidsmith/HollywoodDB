package com.droidsmith.hollywooddb.data.remote.response.tmdb.people;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreditResponse {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("cast")
    @Expose
    public List<Cast> cast = null;
    @SerializedName("crew")
    @Expose
    public List<Crew> crew = null;
}
