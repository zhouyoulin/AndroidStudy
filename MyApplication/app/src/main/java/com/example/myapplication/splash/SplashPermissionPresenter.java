package com.example.myapplication.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import com.example.myapplication.mvp.base.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;

public class SplashPermissionPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.PermissionPresenter {

    private String[] permissions = new String[] {
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };

    // 声明一个集合，在后面的代码中用来存储用户拒绝授权的权
    private List<String> mPermissionList = new ArrayList<>();

    public SplashPermissionPresenter(ISplashActivityContract.IView view) {
        super(view);
    }

    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    @Override
    public void checkPermission() {
        mPermissionList.clear();
        if (Build.VERSION.SDK_INT >= 23) {
            for (int i = 0; i < permissions.length; i++) {
                if (getView().checkSelfPermission(permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                    Log.d("cocos","permissions not  "+permissions[i]);
                    mPermissionList.add(permissions[i]);
                }
            }
        }

        if (mPermissionList.isEmpty()) {// 未授予的权限为空，表示都授予了
            Log.d("cocos","mPermissionList.isEmpty()");
            getView().afterPermission();
        } else {// 请求权限方法
            Log.d("cocos","mPermissionList.notEmpty()");
            String[] permissions = mPermissionList
                    .toArray(new String[mPermissionList.size()]);// 将List转为数组
            getView().requestPermissions(permissions,
                    SplashConstant.MY_PERMISSIONS_REQUEST);
        }
    }
}
