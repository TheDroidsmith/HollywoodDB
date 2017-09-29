package com.droidsmith.hollywooddb.ui.detail.tv;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.Cast;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShowDetails;

import java.util.List;

public interface TVDetailContract {

    interface TVDetailView{
        void setBasicInfo(TVShowDetails movieDetails);
        void setCastList(List<Cast> cast);
    }

    interface TVDetailPresenter{
        void fetchBasicInfo(Integer movieID);
        void fetchCast(Integer movieID);
    }

}
