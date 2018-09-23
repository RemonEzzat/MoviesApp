package com.example.remon.moviesapp.activity.rest;

import android.view.View;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // To send network requests to an API
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static Retrofit retrofit = null;

    public static Retrofit  getClient(){
        if ( retrofit == null ){

            retrofit = new Retrofit.Builder ()
                    .baseUrl ( BASE_URL )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .build ();
        }


        return retrofit;
    }


}
