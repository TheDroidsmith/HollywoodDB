package com.droidsmith.hollywooddb.ui.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;
import com.droidsmith.hollywooddb.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {


    private Context context;
    private List<Movie> movieList;


    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public MovieListAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;

    }

    public MovieListAdapter(Context context) {
        this.movieList = new ArrayList<>();
        this.context = context;
    }

    public void setResults(List<Movie> results){
        this.movieList = results;
        notifyDataSetChanged();
    }

    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.thumbnail_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.ViewHolder holder, int position) {

        holder.getPoster().setTag(movieList.get(position).posterPath);

        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + movieList.get(position).posterPath)
                .into(holder.getPoster());

        holder.getTitle().setTag(movieList.get(position).id);
        holder.getTitle().setText(movieList.get(position).title);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumb_poster)
        ImageView poster;

        @OnClick(R.id.thumb_poster)
        void startDetailActivity(ImageView poster){
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("posterPath", (String)poster.getTag());
            intent.putExtra("movieID", (Integer)title.getTag());

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            (MainActivity)context,(View)poster,"poster");

            context.startActivity(intent, options.toBundle());
        }


        @BindView(R.id.thumb_title)
        TextView title;


        private ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        public TextView getTitle() {
            return title;
        }

        public ImageView getPoster() {
            return poster;
        }


    }


}
