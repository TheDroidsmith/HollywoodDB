package com.droidsmith.hollywooddb.ui.main.fragments.favorites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;


public class FavoritesFragment extends Fragment implements FavoritesFragmentView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.favorites_frag, container, false);

        return rootView;
    }

}
