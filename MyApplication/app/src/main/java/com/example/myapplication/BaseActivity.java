package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * activity基类
 */
public class BaseActivity extends AppCompatActivity {

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
            }else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        }else{
            throw new RuntimeException("mainLayoutId is null");
        }
    }
}
