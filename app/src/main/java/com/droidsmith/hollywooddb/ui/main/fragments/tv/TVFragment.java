package com.droidsmith.hollywooddb.ui.main.fragments.tv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TVFragment extends Fragment implements TVFragmentView {

    Unbinder unbinder;

    public static TVFragment newInstance() {
        TVFragment fragment = new TVFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tv_frag, container, false);

        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
