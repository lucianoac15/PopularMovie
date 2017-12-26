package br.com.luciano.popularmovies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private final Context mContext;
    private final MovieObject[] movies;

    public ImageAdapter(Context context, MovieObject[] movies) {
        mContext = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        if (movies == null) {
            return 0;
        }

        return movies.length;
    }

    @Override
    public Object getItem(int i) {
        if (movies == null || movies.length == 0) {
            return null;
        }

        return movies[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) view;
        }

        Picasso.with(mContext)
                .load(movies[i].getCoverPath())
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.place_holder)
                .into(imageView);

        return imageView;
    }
}
