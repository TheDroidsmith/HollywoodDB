package com.droidsmith.hollywooddb.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.view.fragments.views.HistoryFragmentView;


public class HistoryFragment extends Fragment implements HistoryFragmentView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.history_frag, container, false);

        return rootView;
    }

}
