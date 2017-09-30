package com.droidsmith.hollywooddb.ui.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.model.Favorite;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

@SuppressWarnings({"WeakerAccess","UnusedDeclaration","FieldCanBeLocal"})

public class FavoritesAdapter extends RealmBaseAdapter<Favorite> implements ListAdapter{

    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    private boolean inDeletionMode = false;
    private Set<Integer> favoritesToDelete = new HashSet<Integer>();


    public FavoritesAdapter(@NonNull Context context,
                            @Nullable OrderedRealmCollection<Favorite> data) {
        super(context, data);
    }


    public void changeData(OrderedRealmCollection<Favorite> updatedData){
        updateData(updatedData);
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.fav_row, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(adapterData != null){
            final Favorite fav = adapterData.get(position);
            viewHolder.titleName.setText(fav.getName());

            Picasso.with(context)
                    .load(IMAGE_URL_BASE_PATH + fav.getPosterPath())
                    .into(viewHolder.poster);

            viewGroup.setOnClickListener(v -> {
                //TODO: figure out which detail activity to launch
                Log.d("ListAdapter", "ViewGroup Clicked!!");
            });
        }

        return view;
    }


    void enableDeletionMode(boolean enabled) {
        inDeletionMode = enabled;
        if (!enabled) {
            favoritesToDelete.clear();
        }
        notifyDataSetChanged();
    }

    Set<Integer> getCountersToDelete() {
        return favoritesToDelete;
    }



    public class ViewHolder{

        @BindView(R.id.favPoster)
        ImageView poster;

        @BindView(R.id.favTitleName)
        TextView titleName;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }

}
