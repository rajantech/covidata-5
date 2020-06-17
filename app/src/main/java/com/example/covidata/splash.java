package com.example.covidata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.covidata.MainActivity;
import com.example.covidata.R;

/**
 * Created by Maciek on 12.05.2016.
 */
public class splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final ImageView zoom = (ImageView) findViewById(R.id.img);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoom);
        zoom.startAnimation(zoomAnimation);
        zoomAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Handler mHandler = new Handler(getMainLooper());
                Runnable mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        Intent i = new Intent(splash.this, MainActivity.class);
                        startActivity(i);

                    }
                };
                mHandler.postDelayed(mRunnable, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

