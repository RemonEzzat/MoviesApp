package com.example.remon.moviesapp.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.remon.moviesapp.activity.model.MoviesModel;
import com.example.remon.retrofitexample.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoviesDetails extends AppCompatActivity {

    // bind views

    @BindView ( R.id.image )
    ImageView imageView;
    @BindView ( R.id.textViewOriginalTitle )
    TextView titleView ;
    @BindView ( R.id.textViewOverView )
    TextView overView ;
    @BindView ( R.id.textViewVote_count )
    TextView voteCount;
    @BindView ( R.id.textViewpopularity )
    TextView popul ;
    @BindView ( R.id.textViewRelease_date )
    TextView dateRel;
    @BindView ( R.id.imageback )
    ImageView imageViewback;
    @BindView ( R.id.progress_bar )
    ProgressBar progress_bar;

    // vars
    MoviesModel movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.details_activity );
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if ( movie == null )
            progress_bar.setVisibility ( View.VISIBLE );
        movie =  (MoviesModel)   getIntent ( ).getExtras ().getSerializable ( "movie" );
        progress_bar.setVisibility ( View.GONE );
        String poster =  "https://image.tmdb.org/t/p/w500" + movie.getPosterPath ();
        Picasso.get ().load ( poster ).into ( imageView );
        titleView.setText (  movie.getTitle () );
        overView.setText ("OverView: "+ movie.getOverView () );
        voteCount.setText ("Vote Count: "+ movie.getVoteCount () );
        popul.setText ("Popularity: "+ movie.getPopularity () );
        dateRel.setText ("Release Date: "+ movie.getReleaseDate () );
    } // fill view with data

    @OnClick(R.id.imageback)
    public void  onClickBack(){
        onBackPressed ();
    } // click on back button

}
