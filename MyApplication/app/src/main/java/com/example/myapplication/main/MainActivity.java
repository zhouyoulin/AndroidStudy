package com.example.myapplication.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.ViewInject;
import com.example.myapplication.main.tools.MainConstantTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @BindView(R.id.fb_action)
    FloatingActionButton fbAction;

    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;

    @BindView(R.id.rd_shanghai)
    RadioButton rdShanghai;

    @BindView(R.id.rd_hangzhou)
    RadioButton rdHangzhou;

    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;

    @BindView(R.id.group_shanghai)
    RadioGroup groupShanghai;

    @BindView(R.id.rd_beijing)
    RadioButton rdBeijing;

    @BindView(R.id.rd_shenzhen)
    RadioButton rdShenzhen;

    @BindView(R.id.group_beijing)
    RadioGroup groupBeijing;

    private boolean isChangeTopBottom;

    @Override
    protected void afterBindView() {
        initHomeFragment();
        changeAnimation(groupBeijing, groupShanghai);
        rdShanghai.setChecked(true);
    }

    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    // 点击悬浮按钮切换到上海杭州界面
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() == MainConstantTools.SHANGHAI){
            rdShanghai.setChecked(true);
            mPresenter.replaceFragment(MainConstantTools.SHANGHAI);
        }else{
            rdHangzhou.setChecked(true);
            mPresenter.replaceFragment(MainConstantTools.HANGZHOU);
        }

    }

    // 点击悬浮按钮切换到北京，深圳界面
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() == MainConstantTools.SHENZHEN){
            rdShenzhen.setChecked(true);
            mPresenter.replaceFragment(MainConstantTools.SHENZHEN);
        }else{
            rdBeijing.setChecked(true);
            mPresenter.replaceFragment(MainConstantTools.BEIJING);
        }

    }

    /**
     * 主界面下方按钮显示过度动画
     *
     * @param gone 需要隐藏的radioGroup
     * @param show 需要显示的radioGroup
     */
    private void changeAnimation(RadioGroup gone, RadioGroup show) {
        gone.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main_tap_hide);
        gone.startAnimation(animation);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tap_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        // 显示Fragment
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        // 添加Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        // 隐藏Fragment
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fb_action, R.id.rd_shanghai, R.id.rd_hangzhou, R.id.rd_beijing, R.id.rd_shenzhen})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_action:
                isChangeTopBottom = !isChangeTopBottom;
                if (isChangeTopBottom) {
                    changeAnimation(groupShanghai, groupBeijing);
                    handleTopPosition();
                } else {
                    changeAnimation(groupBeijing, groupShanghai);
                    handleBottomPosition();
                }
                break;
            case R.id.rd_shanghai:
                mPresenter.replaceFragment(MainConstantTools.SHANGHAI);
                break;
            case R.id.rd_hangzhou:
                mPresenter.replaceFragment(MainConstantTools.HANGZHOU);
                break;
            case R.id.rd_beijing:
                mPresenter.replaceFragment(MainConstantTools.BEIJING);
                break;
            case R.id.rd_shenzhen:
                mPresenter.replaceFragment(MainConstantTools.SHENZHEN);
                break;
        }
    }
}
