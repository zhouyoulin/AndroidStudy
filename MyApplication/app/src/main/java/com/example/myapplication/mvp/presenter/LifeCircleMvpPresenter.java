package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvp.ILifeCircle;
import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.MvpController;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    protected WeakReference<T> weakReference;

   protected LifeCircleMvpPresenter(){
       super();
   }

   public LifeCircleMvpPresenter(IMvpView view){
       super();
       attachView(view);
       MvpController mvpController = view.getMvpController();
       mvpController.savePresenter(this);
   }

    @Override
    public void attachView(IMvpView view) {
        if (weakReference == null){
            weakReference = new WeakReference(view);
        }else {
            T mView = weakReference.get();
            if (mView != view){
                weakReference = new WeakReference(view);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView(){
       T view = weakReference != null ? weakReference.get() : null;
       if (view == null){
           return getEmptyView();
       }
       return view;
    }

    protected abstract T getEmptyView();
}
