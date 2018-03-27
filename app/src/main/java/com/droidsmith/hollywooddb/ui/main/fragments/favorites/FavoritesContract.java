package com.droidsmith.hollywooddb.ui.main.fragments.favorites;


import com.droidsmith.hollywooddb.data.local.Favorite;


public interface FavoritesContract {

    interface FavoritesView{
        void updateFavorites();
    }

    interface FavoritesPresenter{



        void fetchFavoritesList();

    }

}
