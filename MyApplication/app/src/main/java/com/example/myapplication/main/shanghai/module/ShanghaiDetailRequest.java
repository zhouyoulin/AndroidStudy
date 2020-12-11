package com.example.myapplication.main.shanghai.module;

import com.example.myapplication.base.JHRequest;
import com.shengqu.dl.http.annotation.RequestMethod;
import com.shengqu.dl.http.request.IRequest;

public interface ShanghaiDetailRequest {

    IRequest xiaohuaRequest = JHRequest.sendHttpRequest("", RequestMethod.GET);
}
