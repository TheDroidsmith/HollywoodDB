package com.droidsmith.hollywooddb.ui.main.fragments.tv;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;

import java.util.List;

public interface TVContract {

    interface TVView{
        void updateAiringTodayList(List<TVShow> results);

        void updateOnTheAirList(List<TVShow> results);

        void updatePopularTVList(List<TVShow> results);

        void updateTopRatedList(List<TVShow> results);
    }

    interface TVPresenter{

        void fetchAiringTodayList();

        void fetchPopularTVList();

        void fetchOnTheAirList();

        void fetchTopRatedList();

        void stop();

    }

}
