package com.example.remon.moviesapp.activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.remon.moviesapp.activity.adapter.MoviesAdapter;
import com.example.remon.moviesapp.activity.model.MovieResponse;
import com.example.remon.moviesapp.activity.model.MoviesModel;
import com.example.remon.moviesapp.activity.rest.ApiClient;
import com.example.remon.moviesapp.activity.rest.ApiInterface;
import com.example.remon.retrofitexample.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // bind views
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView ( R.id.progress_bar )
    ProgressBar progressBar;

    // vars
    private static final String TAG = "MainActivity";
    private static final String API_KEY = "9c493cd74c5e1873fc6196c863c91881";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        ButterKnife.bind ( this );
        checkApi ( );
        initRecyclerView ( );
    }

    private void initRecyclerView() {
        progressBar.setVisibility ( View.VISIBLE );
        recyclerview.setLayoutManager ( new LinearLayoutManager ( this ) );

        ApiInterface apiService =
                ApiClient.getClient ( ).create ( ApiInterface.class );

        Call <MovieResponse> call = apiService.getTopRatedMovies ( API_KEY );
        call.enqueue ( new Callback <MovieResponse> ( ) {
            @Override
            public void onResponse(Call <MovieResponse> call , Response <MovieResponse> response) {
                progressBar.setVisibility ( View.GONE );

                int statusCode = response.code ( );
                String image = response.body ( ).getResults ( ).get ( 0 ).getPosterPath ( );
                List <MoviesModel> movies = response.body ( ).getResults ( );
                recyclerview.setAdapter ( new MoviesAdapter ( movies , R.layout.list_item_movie , getApplicationContext ( ) ) );

            }

            @Override
            public void onFailure(Call <MovieResponse> call , Throwable t) {
                Log.e ( TAG , t.toString ( ) );
            }
        } );
    } // initialize recycler view with movies from api

    private void checkApi() {
        if ( API_KEY.isEmpty ( ) ) {
            Toast.makeText ( getApplicationContext ( ) , "Please obtain your API KEY first from themoviedb.org" ,
                    Toast.LENGTH_LONG ).show ( );
            return;
        }
    } // check api function


}
