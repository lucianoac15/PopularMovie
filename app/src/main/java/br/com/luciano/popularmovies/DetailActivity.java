package br.com.luciano.popularmovies;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }

    @SuppressLint("ValidFragment")
    public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            MovieObject movie = getIntent().getExtras().getParcelable("movie");
            TextView txvTitle =  rootView.findViewById(R.id.txvTitle);
            TextView txvRating = rootView.findViewById(R.id.txvRating);
            TextView txvReleaseDate = rootView.findViewById(R.id.txvReleaseDate);
            TextView txvSysnopsys = rootView.findViewById(R.id.txvSynopsys);
            ImageView imvCover = rootView.findViewById(R.id.imgCover);

            txvSysnopsys.setText(movie.getSynopsis());
            try {
                txvReleaseDate.setText(movie.getReleaseDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            txvRating.setText(movie.getRating().toString());
            Picasso.with(getContext())
                    .load(movie.getCoverPath())
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.place_holder)
                    .into(imvCover);
            txvTitle.setText(movie.getTitle());
            return rootView;
        }
    }
}