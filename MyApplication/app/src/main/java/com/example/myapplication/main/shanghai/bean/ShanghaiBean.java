package com.example.myapplication.main.shanghai.bean;

import java.util.ArrayList;

/**
 * 数据类
 */
public class ShanghaiBean {

    // 显示的类型
    private int mType = IShanghaiItemType.VERTICAL;

    // 显示的描述
    private String mDesc;

    // 是否显示图片
    private boolean isShowImg;

    // 横向显示数据
    private ArrayList<ShanghaiBean> mData;



    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public void setShowImg(boolean showImg) {
        isShowImg = showImg;
    }

    public ArrayList<ShanghaiBean> getmData() {
        return mData;
    }

    public void setmData(ArrayList<ShanghaiBean> mData) {
        this.mData = mData;
    }


    public interface IShanghaiItemType{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }
}
