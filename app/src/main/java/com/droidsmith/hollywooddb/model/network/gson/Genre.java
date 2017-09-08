package com.droidsmith.hollywooddb.model.network.gson;


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
