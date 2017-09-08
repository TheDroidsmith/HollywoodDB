package com.droidsmith.hollywooddb.model.network.gson;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    public String iso6391;
    @SerializedName("name")
    @Expose
    public String name;

}
