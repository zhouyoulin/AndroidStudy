package com.example.myapplication.splash;

import com.shengqu.dl.mvp.mvp.ILifeCircle;
import com.shengqu.dl.mvp.mvp.IMvpView;
import com.shengqu.dl.mvp.mvp.MvpController;

public interface ISplashActivityContract {

    interface IView extends IMvpView {

        void setTvTimer(String timer);

        void setTvClickable(boolean b);

        void requestPermissions(String[] permissions, int myPermissionsRequest);

        int checkSelfPermission(String permission);

        void afterPermission();
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    interface PermissionPresenter extends ILifeCircle{
        void checkPermission();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public void setTvClickable(boolean b) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }

        @Override
        public void requestPermissions(String[] permissions, int myPermissionsRequest) {
        }

        @Override
        public int checkSelfPermission(String permission){
            return 0;
        }

        @Override
        public void afterPermission() {

        }
    };
}
