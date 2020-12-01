package com.example.myapplication.main.shanghai.bean;

import java.util.ArrayList;

/**
 * 数据初始化类，真实开发场景数据应由后端发送
 */
public class ShanghaiDataManager {

    public static ArrayList<ShanghaiBean> getVerData(int len){
        ArrayList<ShanghaiBean> shanghaiBeans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean  bean = new ShanghaiBean();
            bean.setShowImg(false);
            bean.setmDesc("上海" + i);
            shanghaiBeans.add(bean);
        }
        return shanghaiBeans;
    }

    public static ArrayList<ShanghaiBean> getHorData(int len){
        ArrayList<ShanghaiBean> shanghaiBeans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean  bean = new ShanghaiBean();
            bean.setShowImg(true);
            bean.setmDesc("上海Hor" + i);
            shanghaiBeans.add(bean);
        }
        return shanghaiBeans;
    }

    public static ArrayList<ShanghaiBean> getData(){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        data.addAll(getVerData(5));

        ShanghaiBean bean = new ShanghaiBean();
        bean.setmData(getHorData(5));
        bean.setmType(ShanghaiBean.IShanghaiItemType.HORIZONTAL);
        bean.setShowImg(true);
        data.add(bean);

        data.addAll(getVerData(6));

        ShanghaiBean bean1 = new ShanghaiBean();
        bean1.setmData(getHorData(5));
        bean1.setmType(ShanghaiBean.IShanghaiItemType.HORIZONTAL);
        bean1.setShowImg(true);
        data.add(bean1);

        return data;
    }
}
