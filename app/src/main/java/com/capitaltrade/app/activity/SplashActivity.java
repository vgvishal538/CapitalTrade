package com.capitaltrade.app.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.capitaltrade.app.R;
import com.capitaltrade.app.Utils.SharedPrefUtils;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                conditionCheck();
              //  startActivity(new Intent(SplashActivity.this, MainActivity.class));

                // close this activity

            }
        }, SPLASH_TIME_OUT);
    }

    private void conditionCheck() {
        if (SharedPrefUtils.isLoggedIn(SplashActivity.this).isEmpty()){
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }else if (SharedPrefUtils.getLoginType(SplashActivity.this).equals("1")){
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();

        }else if (SharedPrefUtils.getLoginType(SplashActivity.this).equals("0")){
            startActivity(new Intent(SplashActivity.this, FiDashboardActivity.class));
            finish();
        }
    }
}

