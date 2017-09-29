package com.droidsmith.hollywooddb.ui.detail.tv;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.Cast;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShowDetails;
import com.droidsmith.hollywooddb.ui.adapters.CastAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;



/*
    This class is almost entirely copy pasta of MovieDetailActivity, so I should just figure
    out a way to configure the layout based on whether or not the target is a movie or TV show.
    DUH!!
*/

public class TVDetailActivity extends AppCompatActivity
        implements TVDetailContract.TVDetailView{


    @BindView(R.id.poster) ImageView poster;
    @BindView(R.id.nameDetail) TextView nameDetail;
    @BindView(R.id.genreDetail) TextView genreDetail;
    @BindView(R.id.airDateDetail) TextView airDateDetail;
    @BindView(R.id.overviewDetail) TextView overviewDetail;
    @BindView(R.id.castList) RecyclerView castRecyclerView;
    @BindView(R.id.fav_anim_view) LottieAnimationView favAnimationView;

    private CastAdapter castListAdapter;


    private Unbinder unbinder;

    @Inject
    TVDetailContract.TVDetailPresenter presenter;

    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);
        unbinder = ButterKnife.bind(this);
        supportPostponeEnterTransition();//waits for picasso to ready poster for transition


        int tvID = getIntent().getExtras().getInt("tvID");
        String posterPath = getIntent().getExtras().getString("posterPath");

        Picasso.Builder picassoBuilder = new Picasso.Builder(this);
        Picasso picasso = picassoBuilder
                //.indicatorsEnabled(true)
                .build();
        picasso.load(IMAGE_URL_BASE_PATH + posterPath)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .noFade()
                .into(poster, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }
                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });


        setupRecyclerViews();

        if(tvID != 0){
            presenter.fetchBasicInfo(tvID);
            presenter.fetchCast(tvID);
        }else{
            Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show();
            finish();
        }

        favAnimationView.setAnimation("favorite_app_icon.json");

    }

    private void setupRecyclerViews() {
        //setup popular movie list
        LinearLayoutManager castListLayoutManager = new LinearLayoutManager(this);
        castListLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        castRecyclerView.setLayoutManager(castListLayoutManager);

        castListAdapter = new CastAdapter(this);
        castRecyclerView.setAdapter(castListAdapter);
    }


    @Override
    public void setBasicInfo(TVShowDetails tvShowDetailsDetails) {
        nameDetail.setText(tvShowDetailsDetails.name);
        genreDetail.setText(tvShowDetailsDetails.genres.get(0).name);
        airDateDetail.setText(tvShowDetailsDetails.firstAirDate);
        overviewDetail.setText(tvShowDetailsDetails.overview);
    }

    @Override
    public void setCastList(List<Cast> cast) {
        castListAdapter.setResults(cast);
    }



    @OnClick(R.id.fav_anim_view)
    public void animateAndSaveFavorite(){
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f).setDuration(500);

        animator.addUpdateListener(valueAnimator ->
                favAnimationView.setProgress((Float) valueAnimator.getAnimatedValue()));

        if (favAnimationView.getProgress() == 0f) {
            animator.start();
            //TODO: presenter save item to favorites
        } else {
            favAnimationView.setProgress(0f);
            //TODO: presenter remove item from favorites
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }



}
