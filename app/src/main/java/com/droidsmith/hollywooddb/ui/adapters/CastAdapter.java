package com.droidsmith.hollywooddb.ui.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.Cast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ViewHolder> {

    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    private Context context;
    private List<Cast> castList;

    public CastAdapter(Context context, List<Cast> castList) {
        this.context = context;
        this.castList = castList;
    }

    public CastAdapter(Context context) {
        this.context = context;
        this.castList = new ArrayList();
    }

    public void setResults(List<Cast> results){
        this.castList = results;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.thumbnail_person,parent,false);

        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.getHeadshot().setTag(castList.get(position).id);

        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + castList.get(position).profilePath)
                .into(holder.getHeadshot());

        holder.getName().setText(castList.get(position).name);

    }


    @Override
    public int getItemCount() {
        return castList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView headshot;
        TextView name;

        private ViewHolder(View view) {
            super(view);
            headshot = (ImageView) view.findViewById(R.id.thumb_headshot);
            name = (TextView) view.findViewById(R.id.thumb_name);
        }

        public ImageView getHeadshot() {
            return headshot;
        }

        public TextView getName() {
            return name;
        }
    }

}
