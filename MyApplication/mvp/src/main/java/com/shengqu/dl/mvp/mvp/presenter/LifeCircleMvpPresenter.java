package com.shengqu.dl.mvp.mvp.presenter;

import com.shengqu.dl.mvp.mvp.ILifeCircle;
import com.shengqu.dl.mvp.mvp.IMvpView;
import com.shengqu.dl.mvp.mvp.MvpController;

import java.lang.ref.WeakReference;

/**
 * Presenter层负责绑定、释放、获取view层对象，
 * @param <T> IMvpView
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    // view层的虚引用
    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter(){
        super();
    }

    /**
     * 构造函数，绑定view层，并保存Presenter实例
     * @param view
     */
    public LifeCircleMvpPresenter(IMvpView view){
        super();
        attachView(view);
        MvpController mvpController = view.getMvpController();
        mvpController.savePresenter(this);
    }

    /**
     * 虚引用绑定view实例
     * @param view
     */
    @Override
    public void attachView(IMvpView view) {
        if (weakReference == null){
            weakReference = new WeakReference(view);
        }else {
            T mView = weakReference.get();
            if (mView != view){
                weakReference = new WeakReference(view);
            }
        }
    }

    @Override
    public void onDestroy() {
        // 销毁引用
        weakReference = null;
    }

    /**
     * 获取view实例
     * @return view实例
     */
    protected T getView(){
       T view = weakReference != null ? weakReference.get() : null;
       if (view == null){
           return getEmptyView();
       }
       return view;
    }

    /**
     * 抽象方法，子类实现，
     * 获取空的view实例，防止内存泄漏
     * @return
     */
    protected abstract T getEmptyView();
}
