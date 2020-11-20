package com.example.myapplication.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpController implements ILifeCircle{

    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            lifeCircle.onCreate(savedInstanceState, intent, getArguments);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            lifeCircle.onActivityCreated(savedInstanceState, intent, getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            lifeCircle.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onSaveInstanceState(outState);
        }
    }

    @Override
    public void attachView(IMvpView view) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.attachView(view);
        }
    }

    public void savePresenter(ILifeCircle lifeCircle) {
        this.lifeCircles.add(lifeCircle);
    }
}
