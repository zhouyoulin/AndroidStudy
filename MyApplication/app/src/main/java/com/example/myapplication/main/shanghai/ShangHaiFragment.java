package com.example.myapplication.main.shanghai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.ViewInject;
import com.example.myapplication.main.shanghai.adapter.ShanghaiAdapter;
import com.example.myapplication.main.shanghai.bean.ShanghaiDataManager;

import java.util.ArrayList;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {

    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;

    @BindView(R.id.ly_shanghai_collapsing_tool)
    CollapsingToolbarLayout lyShanghaiCollapsingTool;

    @BindView(R.id.shanghai_app_bar_ly)
    AppBarLayout shanghaiAppBarLy;

    @BindView(R.id.shanghai_recyclerView)
    RecyclerView shanghaiRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void afterBindView() {
        initRecyclerView();
        initListener();
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        //设置RecyclerView的layoutmanager
        shanghaiRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        //设置RecyclerView的adapter
        shanghaiRecyclerView.setAdapter(new ShanghaiAdapter(getActivity(), ShanghaiDataManager.getData(), false));
    }

    private void initListener() {
        // appbarlayout 的滑动监听
        shanghaiAppBarLy.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
