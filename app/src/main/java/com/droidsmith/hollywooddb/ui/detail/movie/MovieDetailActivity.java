package com.droidsmith.hollywooddb.ui.detail.movie;

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
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.Cast;
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

public class MovieDetailActivity extends AppCompatActivity
        implements MovieDetailContract.MovieDetailView{

    @BindView(R.id.poster) ImageView poster;
    @BindView(R.id.titleDetail) TextView titleDetail;
    @BindView(R.id.genreDetail) TextView genreDetail;
    @BindView(R.id.revenueDetail) TextView revenueDetail;
    @BindView(R.id.budgetDetail) TextView budgetDetail;
    @BindView(R.id.runtimeDetail) TextView runtimeDetail;
    @BindView(R.id.dateDetail) TextView dateDetail;
    @BindView(R.id.overviewDetail) TextView overviewDetail;
    @BindView(R.id.castList) RecyclerView castRecyclerView;
    @BindView(R.id.fav_anim_view) LottieAnimationView favAnimationView;

    private CastAdapter castListAdapter;

    private Unbinder unbinder;
    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    @Inject
    MovieDetailContract.MovieDetailPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        unbinder = ButterKnife.bind(this);
        supportPostponeEnterTransition();//waits for picasso to ready poster for transition

        int movieID = getIntent().getExtras().getInt("movieID");
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

        if(movieID != 0){
            presenter.fetchBasicInfo(movieID);
            presenter.fetchCast(movieID);
        }else{
            Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show();
            finish();
        }

        favAnimationView.setAnimation("favorite_app_icon.json");

    }



    private void setupRecyclerViews(){
        //setup popular movie list
        LinearLayoutManager castListLayoutManager = new LinearLayoutManager(this);
        castListLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        castRecyclerView.setLayoutManager(castListLayoutManager);

        castListAdapter = new CastAdapter(this);
        castRecyclerView.setAdapter(castListAdapter);
    }

    @OnClick(R.id.fav_anim_view)
    public void animateAndSaveFavorite(){
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f).setDuration(500);

        animator.addUpdateListener(valueAnimator ->
                favAnimationView.setProgress((Float) valueAnimator.getAnimatedValue()));

        if (favAnimationView.getProgress() == 0f) {
            animator.start();
            presenter.saveToFavorites();
        } else {
            favAnimationView.setProgress(0f);
            //TODO: presenter remove item from favorites
        }

    }



    @Override
    public void setBasicInfo(MovieDetails movieDetails) {
        titleDetail.setText(movieDetails.title);
        genreDetail.setText(movieDetails.genres.get(0).name);
        revenueDetail.setText(String.valueOf(movieDetails.revenue));
        budgetDetail.setText(String.valueOf(movieDetails.budget));
        runtimeDetail.setText(String.valueOf(movieDetails.runtime) + "min");
        dateDetail.setText(movieDetails.releaseDate);
        overviewDetail.setText(movieDetails.overview);
    }

    @Override
    public void setCastList(List<Cast> results) {
        castListAdapter.setResults(results);
    }

    @Override
    public void onSuccessfulSave() {
        Toast.makeText(this,"Saved to Favorites", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
