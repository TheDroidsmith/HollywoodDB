package com.droidsmith.hollywooddb.ui.main.fragments.tv;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.ui.adapters.TVShowListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;


public class TVFragment extends Fragment implements TVContract.TVView{

    Unbinder unbinder;

    @BindView(R.id.airingTodayTVList)
    RecyclerView airingTodayRecyclerView;

    @BindView(R.id.popularTVList)
    RecyclerView popularTVRecyclerView;

    @BindView(R.id.onTheAirTVList)
    RecyclerView onTheAirRecyclerView;

    @BindView(R.id.topRatedTVList)
    RecyclerView topRatedRecyclerView;

    TVShowListAdapter onTheAirAdapter, airingTodayAdapter,
            popularTVAdapter, topRatedAdapter;

    @Inject
    TVContract.TVPresenter presenter;

    public static TVFragment newInstance() {
        TVFragment fragment = new TVFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.tv_frag, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        setupAiringToday();
        setupOnTheAir();
        setupPopular();
        setupTopRated();

        fetchData();

        return rootView;
    }


    private void setupAiringToday() {
        LinearLayoutManager airingTodayLayoutManager = new LinearLayoutManager(getActivity());
        airingTodayLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        airingTodayRecyclerView.setLayoutManager(airingTodayLayoutManager);

        airingTodayAdapter = new TVShowListAdapter(getActivity());
        airingTodayRecyclerView.setAdapter(airingTodayAdapter);
    }

    private void setupOnTheAir() {
        LinearLayoutManager onTheAirLayoutManager = new LinearLayoutManager(getActivity());
        onTheAirLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        onTheAirRecyclerView.setLayoutManager(onTheAirLayoutManager);

        onTheAirAdapter = new TVShowListAdapter(getActivity());
        onTheAirRecyclerView.setAdapter(onTheAirAdapter);
    }

    private void setupPopular() {
        LinearLayoutManager popularTVLayoutManager = new LinearLayoutManager(getActivity());
        popularTVLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularTVRecyclerView.setLayoutManager(popularTVLayoutManager);

        popularTVAdapter = new TVShowListAdapter(getActivity());
        popularTVRecyclerView.setAdapter(popularTVAdapter);
    }

    private void setupTopRated() {
        LinearLayoutManager topRatedTVLayoutManager = new LinearLayoutManager(getActivity());
        topRatedTVLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        topRatedRecyclerView.setLayoutManager(topRatedTVLayoutManager);

        topRatedAdapter = new TVShowListAdapter(getActivity());
        topRatedRecyclerView.setAdapter(topRatedAdapter);
    }

    private void fetchData() {
        presenter.fetchAiringTodayList();
        presenter.fetchOnTheAirList();
        presenter.fetchPopularTVList();
        presenter.fetchTopRatedList();
    }


    @Override
    public void updateAiringTodayList(List<TVShow> results) {
        airingTodayAdapter.setResults(results);
    }

    @Override
    public void updateOnTheAirList(List<TVShow> results) {
        onTheAirAdapter.setResults(results);
    }

    @Override
    public void updatePopularTVList(List<TVShow> results) {
        popularTVAdapter.setResults(results);
    }

    @Override
    public void updateTopRatedList(List<TVShow> results) {
        topRatedAdapter.setResults(results);
    }


    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
