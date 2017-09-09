package com.droidsmith.hollywooddb.ui.home.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Result;
import com.droidsmith.hollywooddb.ui.home.adapters.ResultListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;


public class HomeFragment extends Fragment implements HomeFragmentView{

    //@BindView(R.id.popList)
    RecyclerView recyclerView;

    ResultListAdapter popResultsAdapter;
    private LinearLayoutManager layoutManager;

    @Inject
    HomeFragmentPresenter presenter;

    //TODO: get new instance for this



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //presenter = new HomeFragmentPresenterImp(this,);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_frag, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.popList);


        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        popResultsAdapter = new ResultListAdapter(getActivity());
        recyclerView.setAdapter(popResultsAdapter);

        presenter.checkNetworkCall();

        return rootView;
    }


    @Override
    public void updateAdapter(ArrayList<Result> results){
        popResultsAdapter.setResults(results);
    }
}
