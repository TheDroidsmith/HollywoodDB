package com.droidsmith.hollywooddb.ui.detail.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class MovieDetailActivity extends AppCompatActivity
        implements MovieDetailContract.MovieDetailView{

    private Unbinder unbinder;
    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    @Inject
    MovieDetailContract.MovieDetailPresenter presenter;



    @BindView(R.id.poster)
    ImageView poster;

    @BindView(R.id.titleDetail)
    TextView titleDetail;

    @BindView(R.id.genreDetail)
    TextView genreDetail;

    @BindView(R.id.revenueDetail)
    TextView revenueDetail;

    @BindView(R.id.budgetDetail)
    TextView budgetDetail;

    @BindView(R.id.runtimeDetail)
    TextView runtimeDetail;

    @BindView(R.id.dateDetail)
    TextView dateDetail;

    @BindView(R.id.overviewDetail)
    TextView overviewDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        unbinder = ButterKnife.bind(this);



        int movieID = getIntent().getExtras().getInt("movieID");

        if(movieID != 0){
            presenter.fetchBasicInfo(movieID);
        }else{
            Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show();
            finish();
        }



    }

    @Override
    public void setBasicInfo(MovieDetails movieDetails) {

        Picasso picasso
                = new Picasso.Builder(this)
                .indicatorsEnabled(true)
                .build();

        picasso.load(IMAGE_URL_BASE_PATH + movieDetails.posterPath).into(poster);

        titleDetail.setText(movieDetails.title);
        genreDetail.setText(movieDetails.genres.get(0).name);
        revenueDetail.setText(String.valueOf(movieDetails.revenue));
        budgetDetail.setText(String.valueOf(movieDetails.budget));
        runtimeDetail.setText(String.valueOf(movieDetails.runtime) + "min");
        dateDetail.setText(movieDetails.releaseDate);
        overviewDetail.setText(movieDetails.overview);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
