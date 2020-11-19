package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnimation(groupBeijing, groupShanghai);
        rdShanghai.setChecked(true);
    }

    @OnClick(R.id.fb_action)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fb_action:
                isChangeTopBottom = ! isChangeTopBottom;
                if (isChangeTopBottom){
                    changeAnimation(groupShanghai, groupBeijing);
                    rdBeijing.setChecked(true);
                }else{
                    changeAnimation(groupBeijing, groupShanghai);
                    rdShanghai.setChecked(true);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 主界面下方按钮显示过度动画
     * @param gone 需要隐藏的radiogroup
     * @param show 需要显示的radiogroup
     */
    private void changeAnimation(RadioGroup gone, RadioGroup show){
        gone.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main_tap_hide);
        gone.startAnimation(animation);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tap_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }
}
