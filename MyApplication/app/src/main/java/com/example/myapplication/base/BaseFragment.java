package com.example.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.mvp.view.LifeCircleMvpActivity;
import com.example.myapplication.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

/**
 * Fragment基类
 * 主要绑定ButterKnife，和自定义注解ViewInject
 */
public abstract class BaseFragment extends LifeCircleMvpFragment {

    public Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 初始化自定义注解
        View mView = null;
        ViewInject viewInject = this.getClass().getAnnotation(ViewInject.class);
        if (viewInject != null){
            int mainLayoutId = viewInject.mainLayoutId();
            if (mainLayoutId > 0){
                mView = initFragmentView(inflater, mainLayoutId);

                // 初始化ButterKnife 需要在setContentView之后
                ButterKnife.bind(this, mView);
                afterBindView();
            }else {
                throw new RuntimeException("mainLayoutId < 0");
            }
        }else{
            throw new RuntimeException("mainLayoutId is null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int mainLayoutId) {
        View view = inflater.inflate(mainLayoutId, null);
        return view;
    }

    protected abstract void afterBindView();
}
