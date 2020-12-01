package com.example.myapplication.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.main.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.base.ViewInject;

import java.io.File;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    @BindView(R.id.m_videoView)
    FullScreenVideoView mVideoView;

    @BindView(R.id.tv_splash_time)
    TextView tvSplashTime;

    private ISplashActivityContract.IPresenter timerPresenter;

    private ISplashActivityContract.PermissionPresenter permissionPresenter;

    @Override
    protected void afterBindView() {
        initPermissionPresenter();

    }

    private void initPermissionPresenter() {
        permissionPresenter = new SplashPermissionPresenter(this);
        permissionPresenter.checkPermission();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
    }

    private void initListener() {
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        tvSplashTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        });
        setTvClickable(false);
    }

    @Override
    public void setTvTimer(String s) {
        tvSplashTime.setText(s);
    }

    @Override
    public void setTvClickable(boolean clickable){
        tvSplashTime.setClickable(clickable);
    }

    @Override
    public void afterPermission() {
        initTimerPresenter();
        initVideo();
        initListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == SplashConstant.MY_PERMISSIONS_REQUEST) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    // 判断是否勾选禁止后不再询问
                    boolean showRequestPermission = this.shouldShowRequestPermissionRationale(permissions[i]);
                    if (showRequestPermission) {
                        Toast.makeText(SplashActivity.this,"有权限未授权，可能影响游戏体验。建议在权限中打开游戏所使用的权限。",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            if (this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SplashActivity.this,"请打开游戏存储权限以保存文件",Toast.LENGTH_SHORT).show();
                permissionPresenter.checkPermission();
            }else {
                afterPermission();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SplashActivity", "onPause: ");
    }
}
