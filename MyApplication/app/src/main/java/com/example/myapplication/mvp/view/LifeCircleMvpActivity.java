package com.example.myapplication.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.MvpController;

/**
 * MVP activity基类
 * 负责绑定静态代理类MvpController
 * 转发生命周期
 */
public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {

    // 静态代理对象实例
    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if (this.mvpController == null){
            this.mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null){
            intent =  new Intent();
        }
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onCreate(savedInstanceState, intent, null);
            mvpController.onActivityCreated(savedInstanceState, intent, null);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onDestroy();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MvpController mvpController = this.getMvpController();
        if (mvpController != null){
            mvpController.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
