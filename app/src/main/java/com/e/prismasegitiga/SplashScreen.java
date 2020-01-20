package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    private int time = 3000; //3 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading, makan akan pindah ke login activity
                Intent loginAct = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(loginAct);
                finish();
            }
        }, time);

    }
}
