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
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailActivity;
import com.droidsmith.hollywooddb.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TVShowListAdapter extends RecyclerView.Adapter<TVShowListAdapter.ViewHolder>  {


    private Context context;
    private List<TVShow> TVList;


    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public TVShowListAdapter(List<TVShow> TVList, Context context) {
        this.TVList = TVList;
        this.context = context;
    }

    public TVShowListAdapter(Context context) {
        this.TVList = new ArrayList<>();
        this.context = context;
    }


    public void setResults(List<TVShow> results){
        this.TVList = results;
        notifyDataSetChanged();
    }

    @Override
    public TVShowListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.thumbnail_movie,parent,false);

        return new TVShowListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TVShowListAdapter.ViewHolder holder, int position) {

        holder.getPoster().setTag(TVList.get(position).posterPath);

        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + TVList.get(position).posterPath)
                .into(holder.getPoster());

        holder.getTitle().setTag(TVList.get(position).id);
        holder.getTitle().setText(TVList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return TVList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumb_poster)
        ImageView poster;

        @OnClick(R.id.thumb_poster)
        void startDetailActivity(ImageView poster){
            Intent intent = new Intent(context, TVDetailActivity.class);
            intent.putExtra("posterPath", (String)poster.getTag());
            intent.putExtra("tvID", (Integer)name.getTag());

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            (MainActivity)context,(View)poster,"poster");

            context.startActivity(intent, options.toBundle());
        }


        @BindView(R.id.thumb_title)
        TextView name;

        private ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        public TextView getTitle() {
            return name;
        }

        public ImageView getPoster() {
            return poster;
        }


    }



}
