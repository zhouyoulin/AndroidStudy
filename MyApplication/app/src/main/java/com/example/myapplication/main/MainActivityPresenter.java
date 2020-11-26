package com.example.myapplication.main;


import android.support.v4.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.main.beijing.BeiJingFragment;
import com.example.myapplication.main.hangzhou.HangZhouFragment;
import com.example.myapplication.main.shanghai.ShangHaiFragment;
import com.example.myapplication.main.shenzhen.ShenZhenFragment;
import com.example.myapplication.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter{

    // 当前点击的页签
    private int mCurrentFragmentIndex;
    // 保存fragment的数组
    private Fragment[] fragments = new Fragment[4];
    // 当前点击的RadioButton的ID
    private int mCurrentCheckId;
    // 上海，杭州当前点击的是哪个
    private int mTopPosition = 0;
    // 北京，深圳当前点击的是哪个
    private int mBottomPosition = 0;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    /**
     * 初始化fragment
     */
    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        // 将所有的fragment先隐藏
        for (int i = 0; i < fragments.length; i++) {
            if (mCurrentFragmentIndex != i){
                if (fragments[i] != null){
                    hideFragment(fragments[i]);
                }
            }
        }
        // 获取当前页面费fragment
        Fragment mFragment = fragments[mCurrentFragmentIndex];

        if (mFragment != null){
            // 如果当前fragment不为空，直接添加并显示
            addAndShowFragment(mFragment);
            setCurrentIndex(mCurrentFragmentIndex);
        }else {
            // 如果当前fragment为空，根据页签创建添加并显示
            createCurrentFragment(mCurrentFragmentIndex);
            setCurrentIndex(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getCurrentChecked() {
        return mCurrentCheckId;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    /**
     *
     * @param mCurrentFragmentIndex
     */
    private void setCurrentIndex(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex){
            case 0:
                mCurrentCheckId = R.id.rd_shanghai;
                mTopPosition = mCurrentFragmentIndex;
                break;
            case 1:
                mCurrentCheckId = R.id.rd_hangzhou;
                mTopPosition = mCurrentFragmentIndex;
                break;
            case 2:
                mCurrentCheckId = R.id.rd_beijing;
                mBottomPosition = mCurrentFragmentIndex;
                break;
            case 3:
                mCurrentCheckId = R.id.rd_shenzhen;
                mBottomPosition = mCurrentFragmentIndex;
                break;
            default:
                break;
        }
    }

    /**
     * 根据当前页签创建fragment
     * @param mCurrentFragmentIndex 当前页签0-3
     */
    private void createCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex){
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
            default:
                break;
        }
        fragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    private void addAndShowFragment(Fragment mFragment) {
        //判断当前页面是否已经添加到主activity中了
        if (mFragment.isAdded()){
            getView().showFragment(mFragment);
        }else {
            getView().addFragment(mFragment);
        }
    }

    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()){
            getView().hideFragment(fragment);
        }
    }
}
