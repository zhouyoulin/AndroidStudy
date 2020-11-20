package com.example.myapplication.mvp;

public interface IMvpView {

    // 获取静态代理类实例，子类通过该实例进行生命周期关联
    MvpController getMvpController();
}
