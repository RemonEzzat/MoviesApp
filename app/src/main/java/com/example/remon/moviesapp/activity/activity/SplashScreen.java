package com.example.remon.moviesapp.activity.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.remon.retrofitexample.R;

public class SplashScreen extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash_screen );
       openSplashScreen();

    }



    private void openSplashScreen() {
        new Handler ().postDelayed ( new Runnable ( ) {
            @Override
            public void run() {
                // Thi  s method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent (SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity

                finish ();
            }
        },SPLASH_TIME_OUT );
    }
}
