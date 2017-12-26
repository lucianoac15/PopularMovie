package br.com.luciano.popularmovies;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;

public class DetailFragment extends Fragment {

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            MovieObject movie = intent.getExtras().getParcelable("movie");
            TextView txvTitle = rootView.findViewById(R.id.txvTitle);
            TextView txvRating = rootView.findViewById(R.id.txvRating);
            TextView txvReleaseDate = rootView.findViewById(R.id.txvReleaseDate);
            TextView txvSysnopsys = rootView.findViewById(R.id.txvSynopsys);
            ImageView imvCover = rootView.findViewById(R.id.imgCover);


            try {
                txvReleaseDate.setText(movie.getReleaseDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            txvSysnopsys.setText(movie.getSynopsis());
            txvRating.setText(movie.getRating().toString());
            Picasso.with(getContext())
                    .load(movie.getCoverPath())
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.place_holder)
                    .into(imvCover);
            txvTitle.setText(movie.getTitle());
        }

        return rootView;
    }

}
