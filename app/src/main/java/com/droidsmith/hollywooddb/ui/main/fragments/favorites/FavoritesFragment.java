package com.droidsmith.hollywooddb.ui.main.fragments.favorites;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.model.Favorite;
import com.droidsmith.hollywooddb.ui.adapters.FavoritesAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.realm.OrderedRealmCollection;
import io.realm.RealmResults;


public class FavoritesFragment extends Fragment implements FavoritesContract.FavoritesView{

    Unbinder unbinder;

    FavoritesAdapter favAdapter;

    @BindView(R.id.favListView)
    ListView favListView;

    @Inject
    FavoritesContract.FavoritesPresenter presenter;

    public static FavoritesFragment newInstance() {
        FavoritesFragment fragment = new FavoritesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.favorites_frag, container, false);
        unbinder = ButterKnife.bind(this, rootView);


        presenter.fetchFavoritesList();


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void updateFavorites(RealmResults<Favorite> results) {

        if(favAdapter == null){
            favAdapter = new FavoritesAdapter(getActivity(), results);
            favListView.setAdapter(favAdapter);
        } else{
           favAdapter.updateData(results);
        }



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //presenter.closeRealm();
    }

}
