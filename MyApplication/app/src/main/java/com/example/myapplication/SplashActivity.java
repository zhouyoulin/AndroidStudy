package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {


    private FullScreenVideoView mVieoView;
    private TextView m_splash_time;
    private CustomCountDownTimer customCountDownTimer;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVieoView = (FullScreenVideoView)findViewById(R.id.m_videoView);
        m_splash_time = (TextView)findViewById(R.id.tv_splash_time);

        mVieoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + File.separator + R.raw.opvideo));
        mVieoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mVieoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        m_splash_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
        m_splash_time.setClickable(false);
        customCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.CountDownTimerListener() {
            @Override
            public void onTicker(int time) {
                m_splash_time.setText(time+"");
            }

            @Override
            public void onFinish() {
                m_splash_time.setText(R.string.skip);
                m_splash_time.setClickable(true);
            }
        });
        customCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customCountDownTimer.cancel();
    }
}
