package com.droidsmith.hollywooddb.data.model;


import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Favorite extends RealmObject{

    @PrimaryKey
    private int id;

    private String name;
    private String posterPath;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIDString(){
        return Integer.toString(id);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }



}
