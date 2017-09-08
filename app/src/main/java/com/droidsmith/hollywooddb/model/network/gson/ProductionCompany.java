package com.droidsmith.hollywooddb.model.network.gson;


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
