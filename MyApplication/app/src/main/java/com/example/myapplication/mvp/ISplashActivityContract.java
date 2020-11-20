package com.example.myapplication.mvp;

public interface ISplashActivityContract {

    interface IView extends IMvpView {

        void setTvTimer(String timer);

        void setTvClickable(boolean b);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
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
    };
}
