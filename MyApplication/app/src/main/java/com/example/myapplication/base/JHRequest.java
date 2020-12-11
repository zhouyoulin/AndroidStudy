package com.example.myapplication.base;

import com.shengqu.dl.http.annotation.RequestMethod;
import com.shengqu.dl.http.request.IRequest;
import com.shengqu.dl.http.request.LfRequest;

public class JHRequest extends LfRequest {

    public static IRequest sendHttpRequest(String path, @RequestMethod int method){
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.requestMethod = method;
        return request;
    }
}
