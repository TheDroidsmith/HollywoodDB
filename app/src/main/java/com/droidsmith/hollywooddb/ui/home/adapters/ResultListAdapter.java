package com.droidsmith.hollywooddb.ui.home.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ViewHolder> {


    private Context context;
    private ArrayList<Result> movieList;


    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public ResultListAdapter(ArrayList<Result> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    public ResultListAdapter(Context context) {
        this.movieList = new ArrayList<>();
        this.context = context;
    }

    public void setResults(ArrayList<Result> results){
        this.movieList = results;
        notifyDataSetChanged();
    }

    @Override
    public ResultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thumbnail_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ResultListAdapter.ViewHolder holder, int position) {

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



        private TextView title;
        private ImageButton poster;

        private ViewHolder(View movieCard) {
            super(movieCard);
            poster = (ImageButton) itemView.findViewById(R.id.thumb_poster);
            title = (TextView) itemView.findViewById(R.id.thumb_title);
        }


        public TextView getTitle() {
            return title;
        }

        public ImageView getPoster() {
            return poster;
        }


    }


}
