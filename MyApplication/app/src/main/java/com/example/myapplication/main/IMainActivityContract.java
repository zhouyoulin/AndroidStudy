package com.example.myapplication.main;

import android.support.v4.app.Fragment;

import com.shengqu.dl.mvp.mvp.ILifeCircle;
import com.shengqu.dl.mvp.mvp.IMvpView;
import com.shengqu.dl.mvp.mvp.MvpController;

public interface IMainActivityContract {
    interface IView extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentIndex();

        void replaceFragment(int mCurrentFragmentIndex);

        int getCurrentChecked();

        int getTopPosition();

        int getBottomPosition();
    }

    IView emptyView = new IView() {

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
