package com.droidsmith.hollywooddb.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.view.fragments.views.TVFragmentView;


public class TVFragment extends Fragment implements TVFragmentView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tv_frag, container, false);

        return rootView;
    }

}
