package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shengqu.dl.mvp.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

/**
 * activity基类
 */
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化自定义注解
        ViewInject viewInject = this.getClass().getAnnotation(ViewInject.class);
        if (viewInject != null){
            int mainLayoutId = viewInject.mainLayoutId();
            if (mainLayoutId > 0){
                setContentView(mainLayoutId);
                
                // 初始化ButterKnife 需要在setContentView之后
                ButterKnife.bind(this);
                afterBindView();
            }else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        }else{
            throw new RuntimeException("mainLayoutId is null");
        }
    }

    protected abstract void afterBindView();
}
