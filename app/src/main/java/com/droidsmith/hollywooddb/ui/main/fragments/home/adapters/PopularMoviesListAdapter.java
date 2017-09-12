package com.droidsmith.hollywooddb.ui.main.fragments.home.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResults;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PopularMoviesListAdapter extends RecyclerView.Adapter<PopularMoviesListAdapter.ViewHolder> {


    private Context context;
    private ArrayList<PopularMoviesResults> movieList;


    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public PopularMoviesListAdapter(ArrayList<PopularMoviesResults> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    public PopularMoviesListAdapter(Context context) {

        this.movieList = new ArrayList<>();
        this.context = context;
    }

    public void setResults(ArrayList<PopularMoviesResults> results){
        this.movieList = results;
        notifyDataSetChanged();
    }

    @Override
    public PopularMoviesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thumbnail_movie,parent,false);
        //ButterKnife.bind(context, v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PopularMoviesListAdapter.ViewHolder holder, int position) {

        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + movieList.get(position).posterPath)
                .into(holder.getPoster());

        holder.getTitle().setText(movieList.get(position).title);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        //@BindView(R.id.thumb_poster)
        ImageButton poster;

        //@BindView(R.id.thumb_title)
        TextView title;


        private ViewHolder(View movieCard) {
            super(movieCard);

            poster = (ImageButton) movieCard.findViewById(R.id.thumb_poster);
            title = (TextView) movieCard.findViewById(R.id.thumb_title);
        }


        public TextView getTitle() {
            return title;
        }

        public ImageView getPoster() {
            return poster;
        }


    }


}
